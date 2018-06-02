package zk.springboot.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listitem;
import framework.inventory.Uc_Inv_UnplanInventoryIn;
import zk.springboot.bean.UnplanInventoryResult;
import zk.springboot.service.StockType;
import zk.springboot.service.TWStockService;

public class TWStockPurchaseController {
    protected static final Logger logger = LoggerFactory.getLogger(TWStockPurchaseController.class);

    private List<UnplanInventoryResult> purchaseList = null;

    public TWStockPurchaseController() {}


    @Init
    public void init() {
        Uc_Inv_UnplanInventoryIn in = new Uc_Inv_UnplanInventoryIn();
        purchaseList = in.qryUnplanInventoryIn();
    }


    public List<UnplanInventoryResult> getPurchaseList() {
        return purchaseList;
    }


    public void setPurchaseList(List<UnplanInventoryResult> purchaseList) {
        this.purchaseList = purchaseList;
    }

}

