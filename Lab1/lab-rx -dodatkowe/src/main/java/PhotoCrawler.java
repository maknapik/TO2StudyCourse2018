import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.schedulers.Schedulers;
import model.Photo;
import model.PhotoSize;
import util.PhotoDownloader;
import util.PhotoProcessor;
import util.PhotoSerializer;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class PhotoCrawler {

    private static final Logger log = Logger.getLogger(PhotoCrawler.class.getName());

    private final PhotoDownloader photoDownloader;

    private final PhotoSerializer photoSerializer;

    private final PhotoProcessor photoProcessor;

    public PhotoCrawler() throws IOException {
        this.photoDownloader = new PhotoDownloader();
        this.photoSerializer = new PhotoSerializer("./photos");
        this.photoProcessor = new PhotoProcessor();
    }

    public void resetLibrary() {
        photoSerializer.deleteLibraryContents();
    }

    public void downloadPhotoExamples() {
            Observable<Photo> downloadedExamples = photoDownloader.getPhotoExamples();
            downloadedExamples
                    .subscribeOn(Schedulers.io())
                    .compose(processPhotos());
    }

    public void downloadPhotosForQuery(String query) {
        photoDownloader.searchForPhotos(query)
                .compose(processPhotos())
                .subscribe(photoSerializer::savePhoto);
    }

    /* REALIZACJA ZADANIA DODATKOWEGO */
    public void downloadPhotosForMultipleQueries(List<String> topics) {
        photoDownloader.searchForPhotos(topics)
                .subscribe(group -> {
                    if(group.getKey() != PhotoSize.LARGE) {
                        group
                            .filter(photoProcessor::isPhotoValid)
                            .buffer(5)
                            .map(photoProcessor::convertToMiniature)
                            .subscribe(photoSerializer::savePhoto);
                    } else {
                        group
                            .subscribeOn(Schedulers.computation())
                            .map(photoProcessor::convertToMiniature)
                            .subscribe(photoSerializer::savePhoto);
                    }
                });
    }

    ObservableTransformer<Photo, Photo> processPhotos() {
        return observable -> observable
                .filter(photoProcessor::isPhotoValid)
                .map(photoProcessor::convertToMiniature);
    }
}
