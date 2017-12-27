package kelompok.app.sparing.service;

import android.util.Log;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by isfaaghyth on 12/28/17.
 * github: @isfaaghyth
 */

public class NotifEvent {

    public static NotifEvent instance = new NotifEvent();
    private final Subject<Object, Object> mSubject = new SerializedSubject<>(PublishSubject.create());

    public static NotifEvent getInstance() {
        return instance;
    }

    public <T> Subscription register(final Class<T> tClass, Action1<T> onNext) {
        return mSubject
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(new Func1<Object, Boolean>() {
                    @Override public Boolean call(Object o) {
                        return o.getClass().equals(tClass);
                    }
                })
                .map(new Func1<Object, T>() {
                    @Override public T call(Object o) {
                        return (T) o;
                    }
                })
                .subscribe(onNext, new Action1<Throwable>() {
                    @Override public void call(Throwable err) {
                        Log.e("NotifEvent()", err.getMessage());
                    }
                });
    }

    public void unregister(Subscription subscription) {
        subscription.unsubscribe();
        Log.d(this.getClass().getName(), "unregister: " + subscription.isUnsubscribed());
    }

    public void post(Object event) {
        mSubject.onNext(event);
    }

}