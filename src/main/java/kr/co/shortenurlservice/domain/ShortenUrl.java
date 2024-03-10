package kr.co.shortenurlservice.domain;

import java.util.Random;

public class ShortenUrl {
    /**
     * 구현해야 할 기능
     * 1. 단축된 URL
     * 2. 원래의 URL
     * 3. 리다이렉트 카운트
     */
    private String originalUrl;
    private String shortenUrlKey;
    private Long redirectCount;

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortenUrlKey() {
        return shortenUrlKey;
    }

    public Long getRedirectCount() {
        return redirectCount;
    }

    /**
     * Base56 문자열 생성 메서드를 추가
     * <아래의 숫자, 말파벳 대 소문자 일부 제외> => 비슷하게 생겨서 헷갈리기 때문
     * 숫자 0, 대문자 오(O), 소문자 오(o)
     * 숫자 1, 대문자 아이(I), 소문자 엘(l)
     */
    public static String generateShortenUrlKey(){
        String base56Characters = "23456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz";
        Random random = new Random();
        StringBuilder shortenUrlKey = new StringBuilder();

        for (int count = 0; count < 8; count++){
            int base56CharactersIndex = random.nextInt(0, base56Characters.length());
            char base56Character = base56Characters.charAt(base56CharactersIndex);
            shortenUrlKey.append(base56Character);
        }
        return shortenUrlKey.toString();
    }
    public ShortenUrl(String originalUrl, String shortenUrlKey) {
        this.originalUrl = originalUrl;
        this.shortenUrlKey = shortenUrlKey;
        this.redirectCount = 0L;
    }

    public void increaseRedirectCount() {
        this.redirectCount = redirectCount + 1;
    }
}
