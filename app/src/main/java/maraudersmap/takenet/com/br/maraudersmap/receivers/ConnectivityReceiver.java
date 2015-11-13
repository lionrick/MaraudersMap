package maraudersmap.takenet.com.br.maraudersmap.receivers;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import maraudersmap.takenet.com.br.maraudersmap.model.Local;
import maraudersmap.takenet.com.br.maraudersmap.model.LocalDao;
import maraudersmap.takenet.com.br.maraudersmap.model.LocalListener;
import maraudersmap.takenet.com.br.maraudersmap.model.Pessoa;
import maraudersmap.takenet.com.br.maraudersmap.model.PessoaDao;
import maraudersmap.takenet.com.br.maraudersmap.util.NetWorkUtil;

public class ConnectivityReceiver extends BroadcastReceiver implements LocalListener {
    private Local local;

    @Override
    public void onReceive(Context context, Intent intent) {

        LocalDao.getLocal(this);
    }

    @Override
    public void onLoad(Local value) {
        local = value;

        String phoneMacAddress = NetWorkUtil.getMacAddress();
        String routerMacAddres = NetWorkUtil.getRouterMacAddress();

        if (NetWorkUtil.isWifiConnected()) {
            if (routerMacAddres.equalsIgnoreCase(local.getIdentificador())) {
                PessoaDao.insert(new Pessoa("Fulano", phoneMacAddress));
            } else {
                PessoaDao.remove(phoneMacAddress);
            }
        } else {
            PessoaDao.remove(phoneMacAddress);
        }
    }
}
