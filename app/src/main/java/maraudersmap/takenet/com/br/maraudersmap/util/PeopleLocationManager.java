package maraudersmap.takenet.com.br.maraudersmap.util;

import maraudersmap.takenet.com.br.maraudersmap.MaraudersMapApplication;
import maraudersmap.takenet.com.br.maraudersmap.model.Local;
import maraudersmap.takenet.com.br.maraudersmap.model.Pessoa;
import maraudersmap.takenet.com.br.maraudersmap.model.PessoaDao;

public class PeopleLocationManager {

    public static void modifyLocation(){

        Local local = MaraudersMapApplication.getLocal();

        if (local == null) {
            return;
        }

        String phoneMacAddress = NetWorkUtil.getMacAddress();
        String routerMacAddress = NetWorkUtil.getRouterMacAddress();

        if (NetWorkUtil.isWifiConnected()) {
            if (local.getIdentificador().toLowerCase().contains(routerMacAddress.toLowerCase())) {
                PessoaDao.insert(new Pessoa(ProfileUtil.getName(), phoneMacAddress));
            } else {
                PessoaDao.remove(phoneMacAddress);
            }
        } else {
            PessoaDao.remove(phoneMacAddress);
        }
    }
}
