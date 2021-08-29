package com.aca.generactive.generactiveweb.servlet;

import com.aca.generactive.generactiveweb.model.GenerativeItem;
import com.aca.generactive.generactiveweb.model.Item;
import com.aca.generactive.generactiveweb.model.ItemType;
import com.aca.generactive.generactiveweb.model.StockItem;
import com.aca.generactive.generactiveweb.repository.ItemRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(name = "ItemServlet", value = "/items")
public class ItemServlet extends HttpServlet {

    private static final String PARAM_TYPE = "type";

    private final ItemRepository itemRepository = ItemRepository.getInstance();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        resp.getWriter().write(objectMapper.writeValueAsString(itemRepository.findAll()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String typeParam = req.getParameter(PARAM_TYPE);

        if (typeParam == null || typeParam.isEmpty()) {
            resp.setStatus(400);
            resp.getWriter().write("Missing param " + PARAM_TYPE);
            return;
        }

        String body = req.getReader()
                .lines()
                .collect(Collectors.joining());

        ItemType type = ItemType.valueOf(typeParam);
        Item item;

        switch (type) {
            case STOCK:
                item = itemRepository.addItem(objectMapper.readValue(body, StockItem.class));
                break;
            case GENERATIVE:
                item = itemRepository.addItem(objectMapper.readValue(body, GenerativeItem.class));
                break;
            default:
                throw new RuntimeException("Invalid type");
        }

        resp.getWriter().write(objectMapper.writeValueAsString(item));
    }
}
