package com.ds.al.Op;

import java.util.List;

import com.ds.al.entity.LinkedLstEntity;

public interface LinkedLstOp {

	public LinkedLstEntity AddNode(LinkedLstEntity head,int data);
    public List<LinkedLstEntity> SplitNode(LinkedLstEntity head,LinkedLstEntity start,LinkedLstEntity end);
    public Boolean CheckPallindrome(LinkedLstEntity head1,LinkedLstEntity head2);

}
