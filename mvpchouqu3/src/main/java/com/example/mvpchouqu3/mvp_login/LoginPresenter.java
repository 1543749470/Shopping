package com.example.mvpchouqu3.mvp_login;

import com.example.mvpchouqu3.mvp_base.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginView,LoginModelImp> {
    public LoginPresenter(LoginView view) {
        super(view);
    }

    @Override
    protected LoginModelImp initModel() {
        return new LoginModelImp();
    }

    @Override
    public void detachView() {
        view=null;
    }
    public void getLoginAction(String name,String psw){
        model.getLoginData(name, psw, new CallBack<String>() {
            @Override
            public void getLoginDataSuccess(String json) {
                view.updateUISuccess(json);
            }

            @Override
            public void getLoginDataFilade(String error) {
                view.showError(error);
            }
        });
    }
}
