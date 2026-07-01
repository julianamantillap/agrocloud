package com.agrocloud.backend.animal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {

    @Mock
    private AnimalRepository animalRepository;

    @InjectMocks
    private AnimalService animalService;

    private Animal animal;
    private UUID id;

    @BeforeEach
    void setUp() {
        id = UUID.randomUUID();
        animal = new Animal();
        animal.setCodigo("BOV-001");
        animal.setEspecie("Bovino");
        animal.setRaza("Holstein");
        animal.setSexo("hembra");
        animal.setEstado("activo");
    }

    @Test
    void listarTodos_debeRetornarLista() {
        when(animalRepository.findAll()).thenReturn(List.of(animal));

        List<Animal> resultado = animalService.listarTodos();

        assertEquals(1, resultado.size());
        assertEquals("BOV-001", resultado.get(0).getCodigo());
        verify(animalRepository, times(1)).findAll();
    }

    @Test
    void buscarPorId_cuandoExiste_debeRetornarAnimal() {
        when(animalRepository.findById(id)).thenReturn(Optional.of(animal));

        Animal resultado = animalService.buscarPorId(id);

        assertEquals("BOV-001", resultado.getCodigo());
    }

    @Test
    void buscarPorId_cuandoNoExiste_debeLanzar404() {
        when(animalRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class,
                () -> animalService.buscarPorId(id));
    }

    @Test
    void crear_debeGuardarYRetornarAnimal() {
        when(animalRepository.save(animal)).thenReturn(animal);

        Animal resultado = animalService.crear(animal);

        assertEquals("BOV-001", resultado.getCodigo());
        verify(animalRepository, times(1)).save(animal);
    }

    @Test
    void eliminar_cuandoNoExiste_debeLanzar404() {
        when(animalRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class,
                () -> animalService.eliminar(id));

        verify(animalRepository, never()).deleteById(id);
    }
}
