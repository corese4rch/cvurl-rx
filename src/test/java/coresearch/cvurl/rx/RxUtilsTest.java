package coresearch.cvurl.rx;

import io.reactivex.Single;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RxUtilsTest {

    @Test
    public void toSingleOnSuccessTest() {
        //given
        String testValue = "test";
        CompletableFuture<String> future = CompletableFuture.completedFuture(testValue);

        //when
        Single<String> single = RxUtils.toSingle(future);

        //then
        assertEquals(single.blockingGet(), testValue);
    }

    @Test
    public void toSingleOnErrorTest() {
        //given
        CompletableFuture<String> future = CompletableFuture.failedFuture(new RuntimeException());

        //when
        Single<String> single = RxUtils.toSingle(future);

        //then
        assertThrows(RuntimeException.class, () -> single.blockingGet());
    }
}