package kelompok.app.sparing.base;

import android.util.Log;

import kelompok.app.sparing.network.NetworkClient;
import kelompok.app.sparing.network.Routes;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by isfaaghyth on 12/26/17.
 * github: @isfaaghyth
 */

public class BasePresenter<V> {
    public V view;
    protected Routes service;
    private CompositeSubscription compositeSubscription;
    private Subscriber subscriber;

    public void attachView(V view) {
        this.view = view;
        service = NetworkClient.client().create(Routes.class);
    }

    public void dettachView() {
        this.view = null;
        if (compositeSubscription != null && compositeSubscription.hasSubscriptions()) {
            compositeSubscription.unsubscribe();
            Log.e("BasePresenter", "dettachView");
        }
    }

    protected void onSubscribe(Observable observable, Subscriber subscriber) {
        this.subscriber = subscriber;

        if (compositeSubscription == null) {
            compositeSubscription = new CompositeSubscription();
        }
        compositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

    protected void stop() {
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }
}