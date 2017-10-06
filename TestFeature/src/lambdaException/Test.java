package lambdaException;

import java.io.IOException;
import java.util.Optional;

import static lambdaException.ThrowingFunction.unchecked;

/**
 * REF:
 * https://dzone.com/articles/sneakily-throwing-exceptions-in-lambda-expressions?edition=329524&utm_source=Daily%20Digest&utm_medium=email&utm_campaign=Daily%20Digest%202017-10-05
 * 
 */
public class Test {

	public static void main(String[] args) {
		Optional.of(42).map(unchecked(Test::executeLogicError));

	}
	
	private static String executeLogicError(Integer i) throws IOException {
		//do ...... can throw any type Exception
        throw new IOException("whoopsie.");
	}
}
