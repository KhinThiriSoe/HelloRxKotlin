package starting

import doOrDoNot
import exampleOf
import eyesCanDeceive
import iAmYourFather
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import itsNotMyFault
import lackOfFaith
import mayThe4thBeWithYou
import mayTheForceBeWithYou
import printWithLabel
import stayOnTarget

fun main(args: Array<String>) {

    exampleOf("BehaviorSubject") {

        val subscriptions = CompositeDisposable()

        val quotes = BehaviorSubject.createDefault(iAmYourFather)

        val subscriptionOne = quotes.subscribeBy(
                onNext = { printWithLabel("1)", it) },
                onError = { printWithLabel("1)", it) },
                onComplete = { printWithLabel("1)", "Complete") }
        )

        subscriptions.add(subscriptionOne)
        quotes.onError(Quote.NeverSaidThat())

        val subscriptionTwo = quotes.subscribeBy(
                onNext = { printWithLabel("2)", it) },
                onError = { printWithLabel("2)", it) },
                onComplete = { printWithLabel("2)", "Complete") }
        )

        subscriptions.add(subscriptionTwo)

    }

    exampleOf("BehaviorSubject State") {

        val subscriptions = CompositeDisposable()

        val quotes = BehaviorSubject.createDefault(mayTheForceBeWithYou)

        println(quotes.value)

        val subscriptionOne = quotes.subscribeBy(
                onNext = { printWithLabel("1)", it) },
                onError = { printWithLabel("1)", it) },
                onComplete = { printWithLabel("1)", "Complete") }
        )

        subscriptions.add(subscriptionOne)

        quotes.onNext(mayThe4thBeWithYou)
        println(quotes.value)

        quotes.onError(Quote.NeverSaidThat())

        val subscriptionTwo = quotes.subscribeBy(
                onNext = { printWithLabel("1)", it) },
                onError = { printWithLabel("1)", it) },
                onComplete = { printWithLabel("1)", "Complete") }
        )

        subscriptions.add(subscriptionTwo)
    }
}