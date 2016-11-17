package com.lucasimoes.projetostayfilm.model;


import java.util.ArrayList;
import java.util.List;


public class ItemDao {

    private static ItemDao instace;
    private List<Item> listaIt;
    private static long id= 0;

    private ItemDao(List<Item> listaItem){
        this.listaIt = listaItem;
    }

    //simulacao
    private ItemDao(){
        listaIt = new ArrayList<>();
        salvar(new Item("das 08h ao 12h"));
        salvar(new Item("das 12h as 15h"));
        salvar(new Item("das 17h as 22h"));


    }
    //fim

    public static ItemDao getInstace(List<Item> listaIt){
        ItemDao dao = new ItemDao(listaIt);
        ItemDao.instace = dao;
        return dao;
    }

    public static ItemDao getInstace(){
        return instace;
    }

    public void salvar(Item item){
        if (item.getId() == null){
            // incluir
            item.setId(id++);
            listaIt.add(item);

        }else{
            Item obj = localizar(item.getId());
            obj.setHorario(item.getHorario());
            obj.setHorarios(item.isHorarios());

            // atualizar
//            Item Todo = localizar(obj.getId());
//            Todo.setFeito(obj.isFeito());
//            todo.setTitulo(obj.getTitulo());

        }
    }
    public Item localizar (long id){
        Item obj = null;

        for (Item item : listaIt){
            if (item.getId() == id){
                obj = item;
                break;
            }
        }
        return obj;
    }

    public List<Item> listar(){
        return listaIt;
    }

}
