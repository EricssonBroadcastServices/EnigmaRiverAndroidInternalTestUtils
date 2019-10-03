package com.redbeemedia.enigma.core.player;

import com.redbeemedia.enigma.core.time.Duration;

import org.json.JSONException;
import org.json.JSONObject;

public class MockStreamInfo extends StreamInfo {
    public MockStreamInfo(Args args) throws JSONException {
        super(args.toJson());
    }

    public static class Args {
        private boolean live = false;
        private boolean staticManifest = true;
        private Duration start = null;
        private Duration end = null;
        private boolean event = false;
        private String channelId = null;
        private String programId = null;

        public Args() {
        }

        public static Args vod() {
            return new Args().setStaticManifest(true);
        }

        public static Args liveStream() {
            return new Args().setLive(true).setStaticManifest(false);
        }

        public Args setLive(boolean live) {
            this.live = live;
            return this;
        }

        public Args setStaticManifest(boolean staticManifest) {
            this.staticManifest = staticManifest;
            return this;
        }

        public Args setStart(Duration start) {
            this.start = start;
            return this;
        }

        public Args setEnd(Duration end) {
            this.end = end;
            return this;
        }

        public Args setEvent(boolean event) {
            this.event = event;
            return this;
        }

        public Args setChannelId(String channelId) {
            this.channelId = channelId;
            return this;
        }

        public Args setProgramId(String programId) {
            this.programId = programId;
            return this;
        }

        private JSONObject toJson() throws JSONException {
            JSONObject jsonObject =  new JSONObject();
            jsonObject.put("live", live);
            jsonObject.put("static", staticManifest);
            if(start != null) {
                jsonObject.put("start", start.inWholeUnits(Duration.Unit.SECONDS));
            }
            if(end != null) {
                jsonObject.put("end", end.inWholeUnits(Duration.Unit.SECONDS));
            }
            jsonObject.put("event", event);
            if(channelId != null) {
                jsonObject.put("channelId", channelId);
            }
            if(programId != null) {
                jsonObject.put("programId", programId);
            }
            return jsonObject;
        }
    }
}
