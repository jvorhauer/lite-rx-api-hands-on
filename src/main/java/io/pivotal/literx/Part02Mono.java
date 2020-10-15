package io.pivotal.literx;

import reactor.core.publisher.Mono;

/**
 * Learn how to create Mono instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html">Mono Javadoc</a>
 */
public class Part02Mono {

//========================================================================================

	// DONE Return an empty Mono
	Mono<String> emptyMono() {
		return Mono.empty();
	}

//========================================================================================

	// DONE Return a Mono that never emits any signal
	Mono<String> monoWithNoSignal() {
		return Mono.never();
	}

//========================================================================================

	// DONE Return a Mono that contains a "foo" value
	Mono<String> fooMono() {
		return Mono.just("foo");
	}

//========================================================================================

	// DONE Create a Mono that emits an IllegalStateException
	Mono<String> errorMono() {
		return Mono.error(new IllegalStateException());
	}

}
