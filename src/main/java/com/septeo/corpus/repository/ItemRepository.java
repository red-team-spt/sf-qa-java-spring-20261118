package com.septeo.corpus.repository;

import com.septeo.corpus.model.Item;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository {

    private final JdbcTemplate jdbc;
    private static final RowMapper<Item> MAPPER = (rs, i) ->
            new Item(rs.getLong("id"), rs.getString("name"), rs.getString("category"), rs.getInt("quantity"));

    public ItemRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Item findById(long id) {
        return jdbc.queryForObject("SELECT id, name, category, quantity FROM items WHERE id = ?", MAPPER, id);
    }

    public List<Item> searchByName(String name) {
        String sql = "SELECT id, name, category, quantity FROM items WHERE name LIKE '%" + name + "%' ORDER BY name";
        return jdbc.query(sql, MAPPER);
    }

    public List<Item> findByCategory(String category) {
        return jdbc.query("SELECT id, name, category, quantity FROM items WHERE category = ?", MAPPER, category);
    }
}
