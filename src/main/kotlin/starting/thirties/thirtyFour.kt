package starting.thirties

import exampleOf
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import runtimes
import stringFrom

fun main(args: Array<String>) {

    exampleOf("Challenge") {

        val subscriptions = CompositeDisposable()


        val keys = Observable.fromIterable(runtimes.keys)
        val values = Observable.fromIterable(runtimes.values)
        val total = values.scan { a, b -> a + b }
        Observables.zip(keys, values, total)
                .subscribeBy(
                        onNext = {
                            val (movieTitle, runtime, runtimeTotal) = it
                            println("$movieTitle: ${stringFrom(runtime)} (${stringFrom(runtimeTotal)})")
                        })
                .addTo(subscriptions)
    }
}