package com.example.vhr.mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface RoleMenuMapper {
    // 根据角色id删除关联
    @Delete("delete from menu_role where rid=#{rid}")
    int deleteByRid(@Param("rid") Integer rid);

    // 查询角色绑定的所有菜单id
    @Select("select mid from menu_role where rid=#{rid}")
    List<Integer> selectMidByRid(@Param("rid") Integer rid);

    // 批量新增角色菜单
    @Insert("<script>" +
            "insert into menu_role(rid,mid) values " +
            "<foreach collection='midList' item='mid' separator=','>" +
            "(#{rid},#{mid})" +
            "</foreach>" +
            "</script>")
    int insertBatch(@Param("rid")Integer rid,@Param("midList")List<Integer> midList);

    List<Integer> selectMenuIdsByRid(Integer rid);
}