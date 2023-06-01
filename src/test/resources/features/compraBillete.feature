Feature: Automatización de búsqueda de vuelos en Vueling

  Scenario Outline: Seleccionar vuelo de ida y vuelta
    Given El usuario se encuentra en la página de inicio de Vueling
    When El usuario selecciona un billete de ida y vuelta de Barcelona a Madrid
    And La fecha de salida es <diasDesdeFechaActual> días desde la fecha actual
    And La fecha de regreso es <diasDespuesFechaSalida> días después de la fecha de salida
    And El billete seleccionado debe ser para <adultos> adultos y <child> niño
    And El usuario hace clic en `Buscar vuelos`
    And El usuario selecciona un vuelo al azar de la lista de resultados
    And La tarifa seleccionada es <Tarifa> Basica u Optima
    And El usuario hace clic en ´Continuar´
    Then El usuario debería ser redirigido a la página de pasajeros
    Examples:
      | diasDesdeFechaActual | diasDespuesFechaSalida | Tarifa   | adultos| child |
      | 3                    | 4                      | "Basica" |   2    |  1    |
      | 10                   | 2                      | "Optima" |   5    |  3    |
      | 2                    | 10                     | "Optima" |   1    |  6    |