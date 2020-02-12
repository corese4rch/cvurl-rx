package coresearch.cvurl.rx;

import io.reactivex.Single;

import java.util.concurrent.CompletableFuture;

public class RxUtils {

    static <T> Single<T> toSingle(CompletableFuture<T> future) {
        return Single.create(subscriber ->
                future.whenComplete((result, error) -> {
                    if (error != null) {
                        subscriber.onError(error);
                    } else {
                        subscriber.onSuccess(result);
                    }
                }));
    }
}