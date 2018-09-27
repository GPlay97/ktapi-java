package de._125m125.kt.ktapi.core;

import de._125m125.kt.ktapi.core.users.UserKey;

/**
 * The Interface KtNotificationManager.
 */
public interface KtNotificationManager<T extends UserKey<?>> {

    /**
     * Subscribe to updates for messages.
     *
     * @param listener
     *            the listener
     * @param user
     *            the user
     * @param selfCreated
     *            true to listen only to self-created notifications, false to
     *            only listen to non-self-created notification
     */
    public void subscribeToMessages(NotificationListener listener, T userKey, boolean selfCreated);

    /**
     * Subscribe to updates for trades of the user.
     *
     * @param listener
     *            the listener
     * @param user
     *            the user
     * @param selfCreated
     *            true to listen only to self-created notifications, false to
     *            only listen to non-self-created notification
     */
    public void subscribeToTrades(NotificationListener listener, T userKey, boolean selfCreated);

    /**
     * Subscribe to updates for the itemlist.
     *
     * @param listener
     *            the listener
     * @param user
     *            the user
     * @param selfCreated
     *            true to listen only to self-created notifications, false to
     *            only listen to non-self-created notification
     */
    public void subscribeToItems(NotificationListener listener, T userKey, boolean selfCreated);

    /**
     * Subscribe to updates for payouts.
     *
     * @param listener
     *            the listener
     * @param user
     *            the user
     * @param selfCreated
     *            true to listen only to self-created notifications, false to
     *            only listen to non-self-created notification
     */
    public void subscribeToPayouts(NotificationListener listener, T userKey, boolean selfCreated);

    /**
     * Subscribe to updates for orderbooks.
     *
     * @param listener
     *            the listener
     */
    public void subscribeToOrderbook(NotificationListener listener);

    // /**
    // * Subscribe to updates for the orderbook of a specific item.
    // *
    // * @param listener
    // * the listener
    // * @param item
    // * the id of the item
    // */
    // public void subscribeToOrderbook(NotificationListener listener, String
    // item);

    /**
     * Subscribe to updates for historic values.
     *
     * @param listener
     *            the listener
     */
    public void subscribeToHistory(NotificationListener listener);

    // /**
    // * Subscribe to updates for historic values of a specific item.
    // *
    // * @param listener
    // * the listener
    // * @param item
    // * the id of the item
    // */
    // public void subscribeToHistory(NotificationListener listener, String
    // item);

    /**
     * Subscribe to all notifications for a specific user.
     *
     * @param listener
     *            the listener
     * @param u
     *            the u
     * @param selfCreated
     *            true to listen only to self-created notifications, false to
     *            only listen to non-self-created notification
     */
    public default void subscribeToAll(final NotificationListener listener, final T userKey,
            final boolean selfCreated) {
        subscribeToItems(listener, userKey, selfCreated);
        subscribeToMessages(listener, userKey, selfCreated);
        subscribeToPayouts(listener, userKey, selfCreated);
        subscribeToTrades(listener, userKey, selfCreated);
    }

    /**
     * Subscribe to all notification that do not require a logged in user
     *
     * @param listener
     *            the listener
     */
    public default void subscribeToAll(final NotificationListener listener) {
        subscribeToHistory(listener);
        subscribeToOrderbook(listener);
    }

    public void disconnect();

}