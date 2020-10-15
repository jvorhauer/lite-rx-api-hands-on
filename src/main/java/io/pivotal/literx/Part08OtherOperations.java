package io.pivotal.literx;

import io.pivotal.literx.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Learn how to use various other operators.
 *
 * @author Sebastien Deleuze
 */
public class Part08OtherOperations {

//========================================================================================

	// DONE Create a Flux of user from Flux of username, firstname and lastname.
	Flux<User> userFluxFromStringFlux(Flux<String> usernameFlux, Flux<String> firstnameFlux, Flux<String> lastnameFlux) {
		return usernameFlux.map(s -> new User(s, null, null))
               .zipWith(firstnameFlux, (u, f) -> new User(u.getUsername(), f, null))
               .zipWith(lastnameFlux, (u, l) -> new User(u.getUsername(), u.getFirstname(), l));
	}

//========================================================================================

	// DONE Return the mono which returns its value faster
	Mono<User> useFastestMono(Mono<User> mono1, Mono<User> mono2) {
		return  mono1.or(mono2);
	}

//========================================================================================

	// DONE Return the flux which returns the first value faster
	Flux<User> useFastestFlux(Flux<User> flux1, Flux<User> flux2) {
		return flux1.or(flux2);
	}

//========================================================================================

	// DONE Convert the input Flux<User> to a Mono<Void> that represents the complete signal of the flux
	Mono<Void> fluxCompletion(Flux<User> flux) {
		return flux.then();
	}

//========================================================================================

	// DONE Return a valid Mono of user for null input and non null input user (hint: Reactive Streams do not accept null values)
	Mono<User> nullAwareUserToMono(User user) {
		return user == null ? Mono.empty() : Mono.just(User.SKYLER);
	}

//========================================================================================

	// DONE Return the same mono passed as input parameter, expect that it will emit User.SKYLER when empty
	Mono<User> emptyToSkyler(Mono<User> mono) {
		return mono.switchIfEmpty(Mono.just(User.SKYLER));
	}

//========================================================================================

	// DONE Convert the input Flux<User> to a Mono<List<User>> containing list of collected flux values
	Mono<List<User>> fluxCollection(Flux<User> flux) {
		return flux.collect(Collectors.toList());
	}

}
