package FinalProject;

import org.junit.Test;

import static org.junit.Assert.*;

public class PokemonImagesTest{
    PokemonImages images = new PokemonImages();
    
    @Test
    public void getImage(){
        // Get an image by String name
        String pikachuImage = images.getPokemonImage("Pikachu");
        System.out.println("Pikachu:\n" + pikachuImage);
    }   

    @Test
    public void nullImage(){
        // Some Pokemon don't have images, `nothingImage` will be null
        String nothingImage = images.getPokemonImage("nothing");
        assertEquals(null, nothingImage);
    }
        
        
    
        
    
            
        
    
}