package zk.springboot.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listitem;

import framework.inventory.Uc_Inv_UnplanInventoryIn;
import framework.item.Uc_Core_Item;
import zk.springboot.bean.TWIndustry;
import zk.springboot.bean.TWStock;
import zk.springboot.bean.TWStockPrice;
import zk.springboot.service.StockType;
import zk.springboot.service.TWStockService;

//@VariableResolver(DelegatingVariableResolver.class)
public class TWStockController {

	protected static final Logger logger = LoggerFactory.getLogger(TWStockController.class);
	// @WireVariable
	private TWStockService stockService = new TWStockService();

	private ListModelList<Listitem> stockTypes = null;
	private ListModelList<Listitem> industries = null;
	private ListModelList<Listitem> stocks = null;

	private Listitem selectedStockType = null;
	private Listitem selectedIndustry = null;
	private Listitem selectedStock = null;
	private TWStockPrice todayPrice = null;

	private int quantity = 0;

	public TWStockController() {
	}

	@Init
	public void init() {
		stockTypes = new ListModelList<Listitem>();
		for (StockType stockType : StockType.values()) {
			stockTypes.add(new Listitem(stockType.getName(), stockType.getType()));
		}
	}

	@NotifyChange({ "industries" })
	@Command("selectStockType")
	public void selectStockType() {
		logger.info("onSelectStockType {} : {} ", getSelectedStockType().getLabel(), getSelectedStockType().getValue());

		// 設定產業
		List<TWIndustry> twIndustries = stockService.getIndustry(getSelectedStockType().getValue());
		logger.info("TW Industry size : {}", twIndustries.size());

		industries = new ListModelList<Listitem>();
		for (TWIndustry industry : twIndustries) {
			industries.add(new Listitem(industry.getName(), industry.getCode()));
		}
	}

	@NotifyChange({ "stocks" })
	@Command("selectIndustry")
	public void selectIndustry() {
		logger.info("onSelectIndustry {} : {} ", getSelectedIndustry().getLabel(), getSelectedIndustry().getValue());

		// 設定股票
		List<TWStock> twStocks = stockService.getIndustryStocksByType(getSelectedStockType().getValue(),
				getSelectedIndustry().getValue());
		logger.info("TW Stock size : {}", twStocks.size());

		stocks = new ListModelList<Listitem>();
		for (TWStock stock : twStocks) {
			stocks.add(new Listitem(stock.getName() + "(" + stock.getId() + ")", stock.getId()));
		}
	}

	@Command("selectStock")
	public void selectStock() {
		logger.info("onSelectStock {} : {} ", getSelectedStock().getLabel(), getSelectedStock().getValue());
	}

	@NotifyChange({ "todayPrice", "displayTodayPrice" })
	@Command("search")
	public void search() {
		logger.info(" getSelectedStock().getValue() : {}", (String) getSelectedStock().getValue());
		setTodayPrice(stockService
				.getTodayStockPrice(getSelectedStockType().getValue() + "_" + getSelectedStock().getValue()));
	}

	@Command("purchase")
	public void purchase() {
		try {
			logger.info(" getTodayPrice code : {}, lastprice : {}, quantity : {}", getTodayPrice().getCode(),
					getTodayPrice().getLastPrice(), getQuantity());

			Uc_Core_Item item = new Uc_Core_Item();
			HashMap itemResult = item.crtItem(getTodayPrice());
			
			Uc_Inv_UnplanInventoryIn unplanInventoryIn = new Uc_Inv_UnplanInventoryIn();
			String uino = unplanInventoryIn.crtUnplanInventoryIn(getTodayPrice(), getQuantity());
			
			logger.info("[UnplanInventoryIn]  uino : {},  status : {}", uino, unplanInventoryIn.confirm(uino));
		} catch (Throwable cause) {
			logger.error(cause.getMessage(), cause);
		}
	}

	public TWStockService getStockService() {
		return stockService;
	}

	public void setStockService(TWStockService stockService) {
		this.stockService = stockService;
	}

	public ListModelList<Listitem> getStockTypes() {
		return stockTypes;
	}

	public void setStockTypes(ListModelList<Listitem> stockTypes) {
		this.stockTypes = stockTypes;
	}

	public ListModelList<Listitem> getIndustries() {
		return industries;
	}

	public void setIndustries(ListModelList<Listitem> industries) {
		this.industries = industries;
	}

	public Listitem getSelectedStockType() {
		return selectedStockType;
	}

	public void setSelectedStockType(Listitem selectedStockType) {
		this.selectedStockType = selectedStockType;
	}

	public Listitem getSelectedIndustry() {
		return selectedIndustry;
	}

	public void setSelectedIndustry(Listitem selectedIndustry) {
		this.selectedIndustry = selectedIndustry;
	}

	public ListModelList<Listitem> getStocks() {
		return stocks;
	}

	public void setStocks(ListModelList<Listitem> stocks) {
		this.stocks = stocks;
	}

	public Listitem getSelectedStock() {
		return selectedStock;
	}

	public void setSelectedStock(Listitem selectedStock) {
		this.selectedStock = selectedStock;
	}

	public TWStockPrice getTodayPrice() {
		return todayPrice;
	}

	public void setTodayPrice(TWStockPrice todayPrice) {
		this.todayPrice = todayPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
