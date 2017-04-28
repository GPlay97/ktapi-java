package de._125m125.kt.ktapi_java.pinningRequester;

import de._125m125.kt.ktapi_java.core.BUY_SELL;
import de._125m125.kt.ktapi_java.core.KtRequestUtil;
import de._125m125.kt.ktapi_java.core.Result;
import de._125m125.kt.ktapi_java.core.objects.Trade;
import de._125m125.kt.ktapi_java.core.objects.User;
import de._125m125.kt.ktapi_java.simple.Kt;

public class TestWithMain {
    public static void main(final String[] args) {
        // System.setProperty("https.proxyHost", "10.0.2.2");
        // System.setProperty("https.proxyPort", "8888");

        //  @formatter:off
        final KtPinningRequester r = new KtPinningRequester(new User("1","1", "1"));
//        KtPinningRequester r = null;
//        try (InputStream is = TestWithMain.class.getResourceAsStream("www.owasp.org.crt")) {
//            r = new KtPinningRequester(new User("1", "1", "1"), is);
//        } catch (final IOException e) {
//            e.printStackTrace();
//            System.exit(0);
//        }
        //  @formatter:on

        final KtRequestUtil kt = new Kt(r);

        System.out.println(kt.getPermissions());

        System.out.println(kt.getItems());

        System.out.println(kt.getTrades());

        System.out.println(kt.getMessages());

        System.out.println(kt.getPayouts());

        System.out.println(kt.getStatistics("4", 30));

        System.out.println(kt.getOrderBook("4", 30, true));

        final Result<Trade> createTrade = kt.createTrade(BUY_SELL.BUY, "4", 100, 92.67);
        System.out.println(createTrade);

        System.out.println(kt.cancelTrade(createTrade.getObject().getId()));

        System.out.println(kt.takeoutFromTrade(createTrade.getObject().getId()));
    }
}