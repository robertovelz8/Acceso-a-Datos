PROYECTO U3: Herramientas de mapeo objeto-relacional (ORM)

Definición del sistema:

Este proyecto consistirá en una Consultoría Médica, gestionará los pacientes, médicos, las citas, receta médica, 
especialidad del médico, el historial médico del paciente y el equipo médico disponible en el centro de salud.

Objetivo: 
Se describe un sistema para administrar consultorías médicas de un centro de salud. 

RELACIONES:

Paciente - Medico: OneToOne - ManyToOne
Medico - Especialidad: OneToOne - OneToMany (una especialidad y muchos medicos)
Paciente - Cita: OneToMany
Receta - Cita: 