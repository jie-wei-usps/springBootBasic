package ca.bc.gov.chefs.etl.forms.ltc.budget.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class LtcBudgetRev implements IModel {

	private String confirmationId;
	private String revType;
	private String revName;
	private String revBudget;
	private String revNotes;
	
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = StringUtils.defaultIfEmpty(confirmationId, Constants.DEFAULT_STRING_VALUE);
	}
	public String getRevType() {
		return revType;
	}
	public void setRevType(String revType) {
		this.revType = StringUtils.defaultIfEmpty(revType, Constants.DEFAULT_STRING_VALUE);
	}
	public String getRevName() {
		return revName;
	}
	public void setRevName(String revName) {
		this.revName = StringUtils.defaultIfEmpty(revName, Constants.DEFAULT_STRING_VALUE);
	}
	public String getRevBudget() {
		return StringUtils.isBlank(revBudget) ? "0" : revBudget;
	}
	public void setRevBudget(String revBudget) {
		this.revBudget = StringUtils.defaultIfEmpty(revBudget, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getRevNotes() {
		return revNotes != null ? CSVUtil.replaceLineBreaks(revNotes) : revNotes;
	}
	public void setRevNotes(String revNotes) {
		this.revNotes = revNotes;
	}
	
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_BUDGET_REV;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationId());
		elements.add(this.getRevType());
		elements.add(this.getRevName());
		elements.add(this.getRevBudget());
		elements.add(this.getRevNotes());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	
}
