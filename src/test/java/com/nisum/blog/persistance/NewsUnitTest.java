package com.nisum.blog.persistance;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.nisum.blog.model.Author;
import com.nisum.blog.model.Comment;
import com.nisum.blog.model.News;


@RunWith(JUnit4.class)
public class NewsUnitTest {

    @Test
    public void checkIntance() throws Exception {
        NewsImpl noticia;

        noticia = new NewsImpl();

        Assert.assertNotNull(noticia);
    }

    @Test
    public void createNew() throws Exception {
        NewsImpl noticia = new NewsImpl();
        Author autor = new Author();
        autor.setName("Marco Antonio");

        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setAuthor(autor);
        miNoticiaAGuardar.setTitle("mi título");
        miNoticiaAGuardar.setContent("mis comentarios");

        News miNoticia = noticia.create(miNoticiaAGuardar);

        Assert.assertNotNull(miNoticia);
    }

    @Test
    public void checkFields() throws Exception {
        NewsImpl noticia = new NewsImpl();
        Author autor = new Author();
        autor.setName("Marco Antonio");

        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setAuthor(autor);
        miNoticiaAGuardar.setTitle("mi título");
        miNoticiaAGuardar.setContent("mis comentarios");

        News miNoticia = noticia.create(miNoticiaAGuardar);

        Assert.assertNotNull(miNoticia);
        Assert.assertNotNull(miNoticia.getAuthor());
        Assert.assertNotNull(miNoticia.getTitle());
        Assert.assertNotNull(miNoticia.getContent());
    }

    @Test (expected = RuntimeException.class)
    public void checkCaminoInfeliz() throws Exception {
        NewsImpl noticia = new NewsImpl();

        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setTitle("mi título");
        miNoticiaAGuardar.setContent("mis comentarios");

        News miNoticia = noticia.create(miNoticiaAGuardar);
    }

    @Test
    public void checkDelete() throws Exception {
        NewsImpl listaDeNoticias = new NewsImpl();
        Author autor = new Author();
        autor.setName("Marco Antonio");

        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setAuthor(autor);
        miNoticiaAGuardar.setTitle("mi título");
        miNoticiaAGuardar.setContent("mis comentarios");

        News miNoticia = listaDeNoticias.create(miNoticiaAGuardar);
        News miNoticiaBorrada = listaDeNoticias.delete(miNoticia.getId());

        assertNotNull(miNoticiaBorrada);
        assertTrue(listaDeNoticias.isEmpty());
    }

    @Test (expected = RuntimeException.class)
    public void checkDelete2() throws Exception {
        NewsImpl listaDeNoticias = new NewsImpl();

        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setAuthor(new Author());
        miNoticiaAGuardar.setId(11232343);
        miNoticiaAGuardar.setTitle("mi título");
        miNoticiaAGuardar.setContent("mis comentarios");

        News miNoticia = listaDeNoticias.create(miNoticiaAGuardar);
        News miNoticiaBorrada = listaDeNoticias.delete(54746857);
    }


    @Test
    public void checkRead() throws Exception {
        NewsImpl listaDeNoticias = new NewsImpl();
        Author autor = new Author();
        autor.setName("Marco Antonio");
        
        
        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setAuthor(autor);      
        miNoticiaAGuardar.setTitle("mi título");
        miNoticiaAGuardar.setContent("mis comentarios");

        listaDeNoticias.create(miNoticiaAGuardar);
        News miNoticia = listaDeNoticias.read(miNoticiaAGuardar.getId());

        assertNotNull(miNoticia);
        assertTrue(!listaDeNoticias.isEmpty());
    }

    @Test (expected = RuntimeException.class)
    public void checkRead2() throws Exception {
        NewsImpl listaDeNoticias = new NewsImpl();

        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setAuthor(new Author());
        miNoticiaAGuardar.setId(11232343);
        miNoticiaAGuardar.setTitle("mi título");
        miNoticiaAGuardar.setContent("mis comentarios");

        listaDeNoticias.create(miNoticiaAGuardar);
        News miNoticia = listaDeNoticias.read(11233);
    }
    
    @Test
    public void checkReadAllCreate() {
        NewsImpl listaDeNoticias = new NewsImpl();
        Author autor = new Author();
        autor.setName("Marco Antonio");
 
        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setAuthor(autor);
        miNoticiaAGuardar.setTitle("mi título");
        miNoticiaAGuardar.setContent("mis comentarios");
 
        listaDeNoticias.create(miNoticiaAGuardar);
        ArrayList<News> listado = listaDeNoticias.readAll();
        listaDeNoticias.create(miNoticiaAGuardar);
 
        assertEquals(2, listado.size());
    }
 
    @Test
    public void checkReadAllDelete() {
        NewsImpl listaDeNoticias = new NewsImpl();
        Author autor = new Author();
        autor.setName("Marco Antonio");
 
        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setAuthor(autor);
        miNoticiaAGuardar.setTitle("mi título");
        miNoticiaAGuardar.setContent("mis comentarios");
 
        listaDeNoticias.create(miNoticiaAGuardar);
        ArrayList<News> listado = listaDeNoticias.readAll();
        listaDeNoticias.create(miNoticiaAGuardar);
        listaDeNoticias.delete(miNoticiaAGuardar.getId());
 
        assertEquals(1, listado.size());
    }
 
    @Test
    public void checkReadAllNull() {
        NewsImpl listaDeNoticias = new NewsImpl();
 
        ArrayList<News> listado = listaDeNoticias.readAll();
 
        assertTrue(listado.isEmpty());
        assertEquals(0, listado.size());
    }
    
    @Test
    public void checkAuthorNotNull() throws Exception{
        News miNoticia = new News();
        Author autor = new Author();
        autor.setName("juan");
       
       
        miNoticia.setContent("mi contenido");
        miNoticia.setTitle("Esto es un titulo");
        miNoticia.setAuthor(autor);
    }
    
    @Test
    public void checkAddComment() throws Exception {
        NewsImpl listaDeNoticias = new NewsImpl();
 
        News miNoticiaAGuardar = new News();
        Author autor = new Author();
        autor.setName("juan");
        miNoticiaAGuardar.setAuthor(autor);
        miNoticiaAGuardar.setTitle("mi t�tulo");
        miNoticiaAGuardar.setContent("mis comentarios");
        miNoticiaAGuardar = listaDeNoticias.create(miNoticiaAGuardar);
       
        Comment nuevoComentario = new Comment();
        listaDeNoticias.addComment(miNoticiaAGuardar.getId(),nuevoComentario);
       
        assertEquals(1, miNoticiaAGuardar.getComments().size());
    }
   
    @Test (expected = RuntimeException.class)
    public void checkAddComment2() throws Exception {
        NewsImpl listaDeNoticias = new NewsImpl();
        Comment nuevoComentario = new Comment();
        listaDeNoticias.addComment(1234,nuevoComentario);
    }
    
    @Test
    public void checkAddTag(){
        NewsImpl listaDeNoticias = new NewsImpl();
       
        News noticia = new News();
        Author autor = new Author();
        autor.setName("Marco Antonio");
        noticia.setAuthor(autor);
        noticia.setTitle("mi título");
        noticia.setContent("mis comentarios");
        noticia.getTags().add("Deporte");
       
       
        listaDeNoticias.create(noticia);
        News returnNews = listaDeNoticias.searchNewsbyTag(noticia.getId(), "Deporte");
        assertNotNull(returnNews);
    }
}
