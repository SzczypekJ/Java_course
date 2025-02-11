package com.solvd.dao.mybatis;

import com.solvd.model.Library;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface LibraryMapper {

    @Select("SELECT * FROM mydb.libraries WHERE id = #{id}")
    Library getEntityById(int id);

    @Select("SELECT * FROM mydb.libraries")
    List<Library> getEntities();

    @Insert("INSERT INTO mydb.libraries (name, location) VALUES (#{name}, #{location})")
    void insert(Library library);

    @Update("UPDATE mydb.libraries SET name = #{library.name}, location = #{library.location} WHERE id = #{id}")
    void update(@Param("id") int id, @Param("library") Library library);

    @Delete("DELETE FROM mydb.libraries WHERE id = #{id}")
    void delete(@Param("id") int id);
}
