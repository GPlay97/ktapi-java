package de._125m125.kt.ktapi.pusher;

import com.pusher.client.AuthorizationFailureException;
import com.pusher.client.Authorizer;

import de._125m125.kt.ktapi.core.KtRequester;
import de._125m125.kt.ktapi.core.entities.PusherResult;
import de._125m125.kt.ktapi.core.results.Result;
import de._125m125.kt.ktapi.core.users.UserKey;

public class KtPusherAuthorizer<T extends UserKey<?>> implements Authorizer {

    private final T              userKey;
    private final KtRequester<T> requester;

    public KtPusherAuthorizer(final T userKey, final KtRequester<T> requester) {
        this.userKey = userKey;
        this.requester = requester;
    }

    @Override
    public final String authorize(final String channelName, final String socketId)
            throws AuthorizationFailureException {
        final Result<PusherResult> pusherAuthResult = this.requester.authorizePusher(this.userKey,
                channelName, socketId);
        try {
            if (pusherAuthResult.isSuccessful()) {
                return pusherAuthResult.getContent().getAuthdata();
            } else {
                throw new AuthorizationFailureException(pusherAuthResult.getErrorMessage());
            }
        } catch (final Exception e) {
            throw new AuthorizationFailureException(e);
        }
    }
}