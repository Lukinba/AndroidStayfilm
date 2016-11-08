package com.lucasimoes.projetostayfilm.model;


import java.util.List;


public class ItemDao {

    public static ItemDao instace;
    private List<Item> lista;
    private long id= 0;

    private ItemDao(List<Item> lista){
        this.lista = lista;
    }

    public static ItemDao getInstace(List<Item> lista){
        ItemDao dao = new ItemDao(lista);
        ItemDao.instace = dao;

        return dao;
    }

    public static ItemDao getInstace(){
        return instace;
    }

    public void salvar(Item obj){
        if (obj.getId() == null){
            // incluir
            obj.setId(id++);
            lista.add(obj);

        }else{
            // atualizar
//            Item Todo = localizar(obj.getId());
//            Todo.setFeito(obj.isFeito());
//            todo.setTitulo(obj.getTitulo());

        }
    }
    public Item localizar (long id){
        Item obj = null;

        for (Item todo : lista){
            if (todo.getId() == id){
                obj = todo;
                break;
            }
        }
        return obj;
    }

    public List<Item> listar(){
        return lista;
    }

//    public void remover(long id){
//        Item item = localizar(id);
//        if (item != null)
//            lista.remove(item);
//
//    }

}
