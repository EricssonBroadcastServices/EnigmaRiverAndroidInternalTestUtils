//package com.redbeemedia.enigma.core.player;
//
//import com.redbeemedia.enigma.core.error.EnigmaError;
//import com.redbeemedia.enigma.core.error.UnexpectedError;
//import com.redbeemedia.enigma.core.player.controls.IControlResultHandler;
//import com.redbeemedia.enigma.core.playrequest.IPlayResultHandler;
//import com.redbeemedia.enigma.core.playrequest.IPlaybackProperties;
//import com.redbeemedia.enigma.core.session.ISession;
//
//import org.json.JSONObject;
//
//TODO delete class
//public class MockPlaybackSessionFactory implements IPlaybackSessionFactory {
//    public IInternalPlaybackSession newInternalPlaybackSession() {
//        return new MockInternalPlaybackSession(true);
//    }
//
//    @Override
//    public void startAsset(ISession session, IPlaybackProperties playbackProperties, IPlayResultHandler playResultHandler, String assetId, IEnigmaPlayerCallbacks playerConnector, IPlayerImplementationControls playerImplementationControls) {
//        IInternalPlaybackSession playbackSession = newInternalPlaybackSession();
//        playerConnector.deliverPlaybackSession(playbackSession);
//        playerImplementationControls.load(null, new IPlayerImplementationControlResultHandler() {
//            @Override
//            public void onRejected(IControlResultHandler.IRejectReason rejectReason) {
//                playResultHandler.onError(new UnexpectedError("Rejected"));
//            }
//
//            @Override
//            public void onCancelled() {
//                playResultHandler.onError(new UnexpectedError("Cancelled"));
//            }
//
//            @Override
//            public void onError(EnigmaError error) {
//                playResultHandler.onError(error);
//            }
//
//            @Override
//            public void onDone() {
//                playResultHandler.onStarted(playbackSession);
//            }
//        });
//    }
//}
