package com.example.net.rxjava;





import androidx.lifecycle.LifecycleOwner;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
public class ObservableUtils {
    private ObservableUtils() {}
    private static ObservableUtils instance = new ObservableUtils();
    public static ObservableUtils getInstance() {
        return instance;
    }
    public <T> void doObservable(Observable<T> observable, Observer<T> observer, LifecycleOwner owner){
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                /**
                 * 解决Rxjava引发的内存泄漏问题
                 */
//                .as(AutoDispose.<T> autoDisposable(AndroidLifecycleScopeProvider.from(  owner)))
                .subscribe(observer);
    }
}
