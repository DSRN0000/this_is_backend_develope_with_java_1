package kr.co.shortenurlservice.application;

import kr.co.shortenurlservice.domain.ShortenUrlRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotFoundShortenUrlExceptionTest {

    @Mock
    private ShortenUrlRepository shortenUrlRepository;

    @InjectMocks
    private SimpleShortenUrlService simpleShortenUrlService;

    @Test
    @DisplayName("존재하지 않는 단축 URL을 조회하면 예외가 발생해야 한다.")
    void throwNotFoundShortenUrlExceptionTest(){

        String nonExistingShortenUrlKey = "nonExistingKey";

        when(shortenUrlRepository.findShortenUrlByShortenUrlKey(anyString())).thenReturn(null);
        assertThrows(NotFoundShortenUrlException.class, ()-> simpleShortenUrlService.getOriginalUrlByShortenUrlKey(nonExistingShortenUrlKey));

    }

}