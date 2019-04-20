package starting

import detours
import exampleOf
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.PublishSubject
import landOfDroids
import liveLongAndProsper
import mayTheForce
import mayTheOdds
import wookieWorld

fun main(args: Array<String>) {

    exampleOf("IgnoreElements") {

        val subscriptions = CompositeDisposable()

        val cannedProjects = PublishSubject.create<String>()

        subscriptions.add(cannedProjects
                .ignoreElements()
                .subscribeBy {
                    println("Completed")
                })

        cannedProjects.onNext(landOfDroids)
        cannedProjects.onNext(wookieWorld)
        cannedProjects.onNext(detours)

        cannedProjects.onComplete()
    }


    exampleOf("elementAt") {

        val subscriptions = CompositeDisposable()

        val quotes = PublishSubject.create<String>()

        subscriptions.add(
                quotes.elementAt(2) //  Return a Maybe, subscribe with onSuccess instead of onNext
                        .subscribeBy(
                                onSuccess = { println(it) },
                                onComplete = { println("Completed") },
                                onError = { println("Error ${it.localizedMessage}") }
                        )
        )

        quotes.onNext(mayTheOdds)
        quotes.onNext(liveLongAndProsper)
        quotes.onNext(mayTheForce)
    }
}