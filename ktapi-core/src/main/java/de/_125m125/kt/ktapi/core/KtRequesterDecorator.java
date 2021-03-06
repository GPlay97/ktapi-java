package de._125m125.kt.ktapi.core;

import java.io.IOException;
import java.util.List;

import de._125m125.kt.ktapi.core.entities.HistoryEntry;
import de._125m125.kt.ktapi.core.entities.Item;
import de._125m125.kt.ktapi.core.entities.Message;
import de._125m125.kt.ktapi.core.entities.OrderBookEntry;
import de._125m125.kt.ktapi.core.entities.Payout;
import de._125m125.kt.ktapi.core.entities.Permissions;
import de._125m125.kt.ktapi.core.entities.PusherResult;
import de._125m125.kt.ktapi.core.entities.Trade;
import de._125m125.kt.ktapi.core.results.Result;
import de._125m125.kt.ktapi.core.results.WriteResult;
import de._125m125.kt.ktapi.core.users.UserKey;

public class KtRequesterDecorator<T extends UserKey<?>> implements KtRequester<T> {
    private final KtRequester<T> requester;

    public KtRequesterDecorator(final KtRequester<T> requester) {
        this.requester = requester;
    }

    @Override
    public Result<List<HistoryEntry>> getHistory(final String itemid, final int limit,
            final int offset) {
        return this.requester.getHistory(itemid, limit, offset);
    }

    @Override
    public Result<HistoryEntry> getLatestHistory(final String itemid) {
        return this.requester.getLatestHistory(itemid);
    }

    @Override
    public Result<List<OrderBookEntry>> getOrderBook(final String itemid, final int limit,
            final BUY_SELL_BOTH mode, final boolean summarizeRemaining) {
        return this.requester.getOrderBook(itemid, limit, mode, summarizeRemaining);
    }

    @Override
    public Result<List<OrderBookEntry>> getBestOrderBookEntries(final String itemid,
            final BUY_SELL_BOTH mode) {
        return this.requester.getBestOrderBookEntries(itemid, mode);
    }

    @Override
    public Result<Permissions> getPermissions(final T userKey) {
        return this.requester.getPermissions(userKey);
    }

    @Override
    public Result<List<Item>> getItems(final T userKey) {
        return this.requester.getItems(userKey);
    }

    @Override
    public Result<Item> getItem(final T userKey, final String itemid) {
        return this.requester.getItem(userKey, itemid);
    }

    @Override
    public Result<List<Message>> getMessages(final T userKey) {
        return this.requester.getMessages(userKey);
    }

    @Override
    public Result<List<Payout>> getPayouts(final T userKey) {
        return this.requester.getPayouts(userKey);
    }

    @Override
    public Result<WriteResult<Payout>> createPayout(final T userKey, final PAYOUT_TYPE type,
            final String itemid, final String amount) {
        return this.requester.createPayout(userKey, type, itemid, amount);
    }

    @Override
    public void close() throws IOException {
        this.requester.close();
    }

    @Override
    public Result<WriteResult<Payout>> cancelPayout(final T userKey, final long payoutid) {
        return this.requester.cancelPayout(userKey, payoutid);
    }

    @Override
    public Result<WriteResult<Payout>> takeoutPayout(final T userKey, final long payoutid) {
        return this.requester.takeoutPayout(userKey, payoutid);
    }

    @Override
    public Result<PusherResult> authorizePusher(final T userKey, final String channel_name,
            final String socketId) {
        return this.requester.authorizePusher(userKey, channel_name, socketId);
    }

    @Override
    public Result<List<Trade>> getTrades(final T userKey) {
        return this.requester.getTrades(userKey);
    }

    @Override
    public Result<WriteResult<Trade>> createTrade(final T userKey, final BUY_SELL mode,
            final String item, final int amount, final String pricePerItem) {
        return this.requester.createTrade(userKey, mode, item, amount, pricePerItem);
    }

    @Override
    public Result<WriteResult<Trade>> cancelTrade(final T userKey, final long tradeId) {
        return this.requester.cancelTrade(userKey, tradeId);
    }

    @Override
    public Result<WriteResult<Trade>> takeoutTrade(final T userKey, final long tradeId) {
        return this.requester.takeoutTrade(userKey, tradeId);
    }

}
