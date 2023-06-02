package com.example.testdb.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testdb.R;

public class EventHolder extends RecyclerView.ViewHolder {

    private TextView type;
    private TextView reason;
    private TextView dateFrom;
    private TextView dateTo;
    private TextView groupsNum;
    private TextView predmet;

    public EventHolder(@NonNull View itemView) {
        super(itemView);
        type = itemView.findViewById(R.id.eventListItem_name);
        reason = itemView.findViewById(R.id.eventListItem_reason);
        dateFrom = itemView.findViewById(R.id.eventListItem_dateFrom);
        dateTo = itemView.findViewById(R.id.eventListItem_dateTo);
        groupsNum = itemView.findViewById(R.id.employeeListItem_group);
        predmet = itemView.findViewById(R.id.eventListItem_predmet);
    }

    public TextView getType() {
        return type;
    }

    public void setType(TextView type) {
        this.type = type;
    }

    public TextView getReason() {
        return reason;
    }

    public void setReason(TextView reason) {
        this.reason = reason;
    }

    public TextView getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(TextView dateFrom) {
        this.dateFrom = dateFrom;
    }

    public TextView getDateTo() {
        return dateTo;
    }

    public void setDateTo(TextView dateTo) {
        this.dateTo = dateTo;
    }

    public TextView getGroupsNum() {
        return groupsNum;
    }

    public void setGroupsNum(TextView groupsNum) {
        this.groupsNum = groupsNum;
    }

    public TextView getPredmet() {
        return predmet;
    }

    public void setPredmet(TextView predmet) {
        this.predmet = predmet;
    }
}
