package coresearch.cvurl.rx;

import coresearch.cvurl.io.mapper.BodyType;
import coresearch.cvurl.io.model.Response;
import coresearch.cvurl.io.request.Request;
import io.reactivex.rxjava3.core.Single;

import java.io.InputStream;
import java.net.http.HttpResponse;

import static coresearch.cvurl.rx.RxUtils.toSingle;

public class RxRequest {
    private Request request;

    private RxRequest(Request request) {
        this.request = request;
    }

    public static RxRequest rx(Request request) {
        return new RxRequest(request);
    }

    public <T> Single<T> asObject(Class<T> type, int statusCode) {
        return toSingle(request.asyncAsObject(type, statusCode));
    }

    public <T> Single<T> asObject(BodyType<T> type, int statusCode) {
        return toSingle(request.asyncAsObject(type, statusCode));
    }

    public <T> Single<T> asObject(Class<T> type) {
        return toSingle(request.asyncAsObject(type));
    }

    public <T> Single<T> asObject(BodyType<T> type) {
        return toSingle(request.asyncAsObject(type));
    }

    public Single<Response<String>> asString() {
        return toSingle(request.asyncAsString());
    }

    public Single<Response<String>> asString(HttpResponse.PushPromiseHandler<String> pph) {
        return toSingle(request.asyncAsString(pph));
    }

    public Single<Response<InputStream>> asStream() {
        return toSingle(request.asyncAsStream());
    }

    public Single<Response<InputStream>> asStream(HttpResponse.PushPromiseHandler<InputStream> pph) {
        return toSingle(request.asyncAsStream(pph));
    }

    public <T> Single<Response<T>> as(HttpResponse.BodyHandler<T> bodyHandler) {
        return toSingle(request.asyncAs(bodyHandler));
    }

    public <T> Single<Response<T>> as(HttpResponse.BodyHandler<T> bodyHandler, HttpResponse.PushPromiseHandler<T> pph) {
        return toSingle(request.asyncAs(bodyHandler, pph));
    }
}