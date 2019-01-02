package bwie.com.liyongtao20130102.home.presenter;

import bwie.com.liyongtao20130102.MainActivity;
import bwie.com.liyongtao20130102.api.Api;
import bwie.com.liyongtao20130102.home.molder.HomeMolder;

public class HomePresenter implements IHomePresenter,HomeMolder.molderInterface {
    MainActivity mainActivity;
    private final HomeMolder homeMolder;


    public HomePresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        homeMolder = new HomeMolder(this);
    }

    @Override
    public void getModel() {
        homeMolder.getMolderData(Api.SHOPLIST);
    }

    @Override
    public void LoadSuccess(String data) {
        mainActivity.getViewData(data);
    }

    @Override
    public void LoadFile() {
        mainActivity.getViewData("失败");
    }
}
