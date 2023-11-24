package tr.havelsan.kovan.apigen.menu.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class TreeNode<T> {
    String key, label, icon;
    T data;
    List<TreeNode<T>> children;

}
