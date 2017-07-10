package org.kitpes.model.filter;

import lombok.Data;
import org.kitpes.model.Organization;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mac on 01.07.17.
 */
@Data
public class FilterOrg {
    String type;

    public List<Organization> filtering(List<Organization> orgList) {
        return orgList.stream()
                .filter(o -> (type.equals("type") || o.isType() == Boolean.valueOf(type)))
                .collect(Collectors.toList());
    }
}
