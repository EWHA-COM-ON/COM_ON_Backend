package com.ewhacse.biz.board;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;


public class OrgChartNode {
	@ApiModelProperty(value = "이름", example = "윤하영", required = true)
    private String name;
	@ApiModelProperty(value = "직급?", example = "1", required = true)
    private int level;
	
    private List<OrgChartNode> children;

    public OrgChartNode(String name, int level) {
        this.name = name;
        this.level = level;
        this.children = new ArrayList<OrgChartNode>();
    }

    public String getName() {
        return name;
    }
    public int getLevel() {
    	return level;
    }

    public List<OrgChartNode> getChildren() {
        return children;
    }

    public void addChild(OrgChartNode child) {
        this.children.add(child);
    }
}
