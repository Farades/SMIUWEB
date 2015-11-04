package ru.entel.smiu.web.settings;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import ru.entel.smiu.web.settings.devices.DevModelBoard;
import ru.entel.smiu.web.settings.service.ProtocolBlank;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class TreeNodeModel implements Serializable {
    private TreeNode root;
    private TreeNode selectedNode;

    @PostConstruct
    public void init() {
        root = new DefaultTreeNode();

        TreeNode modbusIn = new DefaultTreeNode(new ProtocolBlank("Modbus_In"), root);

        TreeNode modBoard = new DefaultTreeNode(new DevModelBoard("Modeling board 1"), modbusIn);

    }

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public void displaySelectedSingle() {
        if(selectedNode != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", selectedNode.getData().toString());
            FacesContext.getCurrentInstance().addMessage(null, message);
            System.out.println(selectedNode.getData().toString());
        }
    }

    public void deleteNode() {
        selectedNode.getChildren().clear();
        selectedNode.getParent().getChildren().remove(selectedNode);
        selectedNode.setParent(null);

        selectedNode = null;
    }
}
