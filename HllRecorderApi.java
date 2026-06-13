package com.lalamove.huolala.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.delivery.wp.encrypt.obf.f52;
import com.delivery.wp.encrypt.obf.sa2;
import com.delivery.wp.encrypt.obf.va2;
import com.delivery.wp.poll.HDLXManager;
import com.lalamove.huolala.config.ConfigOptions;
import com.lalamove.huolala.manager.HllRecorderManager;
import com.lalamove.huolala.net.RecordNetworkApi;
import com.lalamove.huolala.upload.LoggerUploader;
import com.wp.apm.evilMethod.core.AppMethodBeat;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class HllRecorderApi implements f52 {
    private ConfigOptions OOO0;
    private final sa2 OOOO;
    private boolean OOOo;
    private va2 OOoO;
    private List<String> OOoo;

    private static final class Holder {
        public static HllRecorderApi OOOO;

        static {
            AppMethodBeat.i(4755123);
            OOOO = new HllRecorderApi(null);
            AppMethodBeat.o(4755123);
        }
    }

    class OOOO extends com.delivery.wp.poll.OOOO {
        OOOO(String str, long j) {
            super(str, j);
        }

        @Override // com.delivery.wp.poll.OOOO
        public void onPoll() {
            AppMethodBeat.i(1779944694);
            if (HllRecorderApi.OOoo(HllRecorderApi.this)) {
                AppMethodBeat.o(1779944694);
                return;
            }
            if (HllRecorderApi.this.OO00() == null) {
                ConfigOptions.printLog("轮训回调事件：isRecoding=" + HllRecorderApi.this.OoO0());
            } else {
                ConfigOptions.printLog("轮训回调事件：getOrderIds.size=" + HllRecorderApi.this.OO00().size() + " isRecoding=" + HllRecorderApi.this.OoO0());
            }
            if (HllRecorderApi.this.OO00() != null && HllRecorderApi.this.OO00().size() > 0 && !HllRecorderApi.this.OoO0()) {
                ConfigOptions.printLog("轮训开启的录音，开启录音");
                HllRecorderApi.this.OOOo("");
            }
            AppMethodBeat.o(1779944694);
        }
    }

    /* synthetic */ HllRecorderApi(OOOO oooo) {
        this();
    }

    public static HllRecorderApi OO0o() {
        return Holder.OOOO;
    }

    private boolean OOo0() {
        AppMethodBeat.i(521598734);
        if (this.OOOo) {
            AppMethodBeat.o(521598734);
            return false;
        }
        Log.e("Hll.RecorderApi", "please init then invoke this method");
        AppMethodBeat.o(521598734);
        return true;
    }

    static /* synthetic */ boolean OOoo(HllRecorderApi hllRecorderApi) {
        AppMethodBeat.i(4841394);
        boolean zOOo0 = hllRecorderApi.OOo0();
        AppMethodBeat.o(4841394);
        return zOOo0;
    }

    private void OoOo(Context context, long j) {
        AppMethodBeat.i(1543320055);
        HDLXManager.OOO0(context);
        HDLXManager.OOOO().OoOO(50L);
        HDLXManager.OOOO().OO0o(new OOOO("loopRecorder", j));
        AppMethodBeat.o(1543320055);
    }

    public List<String> OO00() {
        return this.OOoo;
    }

    public ConfigOptions OO0O() {
        return this.OOO0;
    }

    public void OOO0() {
        AppMethodBeat.i(850122240);
        if (OOo0()) {
            AppMethodBeat.o(850122240);
        } else {
            this.OOOO.OOO0();
            AppMethodBeat.o(850122240);
        }
    }

    @Override // com.delivery.wp.encrypt.obf.f52
    public void OOOO(ConfigOptions configOptions) {
        AppMethodBeat.i(4831684);
        if (configOptions == null || configOptions.getContext() == null || TextUtils.isEmpty(configOptions.getEnv())) {
            LoggerUploader.OOOo("configOptions &  context  & env can not be null, please check...");
        }
        this.OOO0 = configOptions;
        this.OOOO.OOOO(configOptions);
        if (!TextUtils.isEmpty(configOptions.getEnv())) {
            RecordNetworkApi.OO0o(configOptions.getEnv());
        }
        OoOo(configOptions.getContext(), configOptions.getExceptionPollTimeMs());
        this.OOOo = true;
        AppMethodBeat.o(4831684);
    }

    public void OOOo(String str) {
        AppMethodBeat.i(1796885355);
        if (OOo0()) {
            AppMethodBeat.o(1796885355);
        } else {
            this.OOOO.OOOo(str);
            AppMethodBeat.o(1796885355);
        }
    }

    public boolean OoO0() {
        AppMethodBeat.i(284967056);
        if (OOo0()) {
            AppMethodBeat.o(284967056);
            return false;
        }
        boolean zOOoO = this.OOOO.OOoO();
        AppMethodBeat.o(284967056);
        return zOOoO;
    }

    public va2 OoOO() {
        return this.OOoO;
    }

    public void OooO(List<String> list) {
        this.OOoo = list;
    }

    public void Oooo(va2 va2Var) {
        this.OOoO = va2Var;
    }

    private HllRecorderApi() {
        AppMethodBeat.i(431295467);
        this.OOOO = new HllRecorderManager();
        AppMethodBeat.o(431295467);
    }
}
