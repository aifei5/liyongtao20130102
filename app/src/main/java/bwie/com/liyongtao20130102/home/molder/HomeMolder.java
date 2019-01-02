package bwie.com.liyongtao20130102.home.molder;

import bwie.com.liyongtao20130102.network.OkHttp;

public class HomeMolder implements IHomeMolder {
    molderInterface molderInterface;

    public HomeMolder(HomeMolder.molderInterface molderInterface) {
        this.molderInterface = molderInterface;
    }

    @Override
    public void getMolderData(final String url) {
        new Runnable(){
            @Override
            public void run() {
                OkHttp.OkHttpGet(url, new OkHttp.getData() {
                    @Override
                    public void getData(String data) {
                        molderInterface.LoadSuccess(data);
                    }
                });
            }
        }.run();
    }
    public interface molderInterface{
        void LoadSuccess(String data);

        void LoadFile();

    }

}
