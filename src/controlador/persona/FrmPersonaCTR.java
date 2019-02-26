package controlador.persona;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.lugar.LugarBD;
import modelo.lugar.LugarMD;
import modelo.persona.PersonaBD;
import modelo.persona.PersonaMD;
import modelo.persona.TipoPersonaBD;
import modelo.persona.TipoPersonaMD;
import modelo.validaciones.Validar;
import vista.persona.FrmPersona;
import vista.principal.VtnPrincipal;

/**
 *
 * @author Lina
 */
public class FrmPersonaCTR {

    private final VtnPrincipal vtnPrin;
    private final FrmPersona frmPersona;
    private PersonaBD persona;

    //Para cargar los paises  
    private ArrayList<LugarMD> paises;
    private ArrayList<LugarMD> distritos;
    private ArrayList<LugarMD> ciudades;
    //Lugar donde reside  
    private ArrayList<LugarMD> provincias;
    private ArrayList<LugarMD> cantones;
    private ArrayList<LugarMD> parroquias;

    //Para consultar lugares 
    LugarBD lug = new LugarBD();
    //Para consultar tipos de persona
    TipoPersonaBD tip = new TipoPersonaBD();
    //Aqui se guardaran los tipos de persona  
    private ArrayList<TipoPersonaMD> tiposPer;
    //Para guardar la foto  
    private FileInputStream fis = null;
    private int lonBytes = 0;

    //Para saber si se esta editando una persona  
    private boolean editar = false;

    public FrmPersonaCTR(VtnPrincipal vtnPrin, FrmPersona frmPersona) {
        this.vtnPrin = vtnPrin;
        this.frmPersona = frmPersona;
        //Inicializamos persona
        this.persona = new PersonaBD();

      //  vtnPrin.getDpnlPrincipal().add(frmPersona);
        frmPersona.show();
        //Para iniciar los combos de paises 
        cargarPaises();
    }

  

    public void iniciar() {
        //Ocultamos todos los erores del formulario 
        ocultarErrores();
        //Cargamos los tipos de persona  
        cargarTiposPersona();

        //Cuando se realice una accion en alguno de esos combos 
        frmPersona.getCmbNacionalidad().addActionListener(e -> cargarDistritosPais());
        frmPersona.getCmbProvincia().addActionListener(e -> cargarCiudadesDistrito());
        frmPersona.getCmbPaisReside().addActionListener(e -> cargarProvinciasResidencia());
        frmPersona.getCmbProvinciaReside().addActionListener(e -> cargarCantonesProvincia());
        frmPersona.getCmbCantonReside().addActionListener(e -> cargarParroquiaCanton());
        frmPersona.getCmbParroquiaReside().addActionListener(e -> cargarCodigoPostal());

        frmPersona.getBtnBuscarFoto().addActionListener(e -> buscarFoto());
        frmPersona.getBtnGuardarPersona().addActionListener(e -> guardarPersona());
        //frmPersona.getBtnBuscarPersona().addActionListener(e -> buscarPersona());
        frmPersona.getBtnCancelar().addActionListener(e -> salirBoton());
        // frmPersona.getBtnBuscarPersona().addActionListener(e -> buscarPersona());

        //Accion de buscar una persona  
        frmPersona.getBtnBuscarPersona().addActionListener(e -> consular());
    }

    public void buscarFoto() {
        frmPersona.getLblFoto().setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                //Para guardar la foto  
                fis = new FileInputStream(j.getSelectedFile());
                lonBytes = (int) j.getSelectedFile().length();

                Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(frmPersona.getLblFoto().getWidth(),
                        frmPersona.getLblFoto().getHeight(), Image.SCALE_SMOOTH);
                frmPersona.getLblFoto().setIcon(new ImageIcon(icono));
                frmPersona.getLblFoto().updateUI();
            } catch (IOException e) {
                //mensaje humane getMesagge()
                JOptionPane.showMessageDialog(null, "No se puedo cargar la imagen");
                System.out.println("Nose puedo cargar la imagen" + e.getMessage());
            }
        }
    }

    public void guardarPersona() {

        //Fecha actual usada para validaciones  
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = fechaActual;
        //Para validar todo  
        boolean guardar = true;
        //unicamente tocoa validar eso es lo feo :$$$$ 
        //Todas las variables del formulario
        String identificacion = "aa", priNombre = "aa", segNombre = "aaa",
                priApellido = "aaa", segApellido = "aaa",
                fechaNac = "aa", estadoCivil = "aaaa", tipoSangre = "aaa", genero = "aaa",
                sexo = "M", etnia = "aaa", carnetConadis = "aaaa",
                tipoDiscapacidad = "aaaa", porcentajeDiscapacidad = "aaaa",
                idiomaRaiz = "aaa", telefono = "aaaa", callePrin = "aaaa",
                calleSec = "aaa", referencia = "aaaa",
                celular = "aaaa", numCasa = "aaa", sector = "aaa",
                zonaResidencia = "aaaaa", correo = "aaaa";

        boolean discapcidad = false;
        int tipoIdentifi;

        identificacion = frmPersona.getTxtIdentificacion().getText();

        /*tipoIdentifi = frmPersona.getCmbTipoId().getSelectedIndex();
        if (tipoIdentifi == 1) {
            if (!Validar.esCedula(identificacion)) {
                guardar = false;
                frmPersona.getLblErrorIdentificacion().setVisible(true);
            } else {
                frmPersona.getLblErrorIdentificacion().setVisible(false);
            }
        } else {
            //Validar cuando es pasaporte 
        }*/
        priNombre = frmPersona.getTxtPrimerNombre().getText();
        if (!Validar.esLetras(priNombre)) {
            guardar = false;
            frmPersona.getLblErrorPriNombre().setVisible(true);
        } else {
            frmPersona.getLblErrorPriNombre().setVisible(false);
        }
        segNombre = frmPersona.getTxtSegundoNombre().getText();
        if (!Validar.esLetras(segNombre)) {
            guardar = false;
            frmPersona.getLblErrorSegNombre().setVisible(true);
        } else {
            frmPersona.getLblErrorSegNombre().setVisible(false);
        }
        priApellido = frmPersona.getTxtPrimerApellido().getText();
        if (!Validar.esLetras(priApellido)) {
            guardar = false;
            frmPersona.getLblErrorPriApellido().setVisible(true);

        } else {
            frmPersona.getLblErrorPriApellido().setVisible(false);
        }
        segApellido = frmPersona.getTxtSegundoApellido().getText();
        if (!Validar.esLetras(segApellido)) {
            guardar = false;
            frmPersona.getLblErrorSegApellido().setVisible(true);
        } else {
            frmPersona.getLblErrorSegApellido().setVisible(false);
        }

        fechaNac = frmPersona.getJdcFechaNacimiento().getText();
        //Auxiliar para transformar de tipo texto a tipo LocalDate
        String fec[] = fechaNac.split("/");

        if (Integer.parseInt(fec[2]) > fechaActual.getYear()
                || Integer.parseInt(fec[2]) > (fechaActual.getYear() - 16)) {
            guardar = false;
            frmPersona.getLblErrorFecNac().setVisible(true);
        } else {
            fechaNacimiento = LocalDate.of(Integer.parseInt(fec[2]),
                    Integer.parseInt(fec[1]), Integer.parseInt(fec[0]));
            frmPersona.getLblErrorFecNac().setVisible(false);
        }

        if (frmPersona.getCmbEstadoCivil().getSelectedIndex() < 1) {
            guardar = false;
            frmPersona.getLblErrorEstadoCivil().setVisible(true);
        } else {
            estadoCivil = frmPersona.getCmbEstadoCivil().getSelectedItem().toString();
            frmPersona.getLblErrorEstadoCivil().setVisible(false);
        }

        if (frmPersona.getCmbGenero().getSelectedIndex() < 1) {
            guardar = false;
            frmPersona.getLblErrorGenero().setVisible(true);
        } else {
            genero = frmPersona.getCmbGenero().getSelectedItem().toString();
            frmPersona.getLblErrorGenero().setVisible(false);
        }

        if (frmPersona.getCmbSexo().getSelectedIndex() < 1) {
            guardar = false;
            frmPersona.getLblErrorSexo().setVisible(true);
        } else {
            sexo = frmPersona.getCmbSexo().getSelectedItem().toString();
            frmPersona.getLblErrorSexo().setVisible(false);
        }

        if (frmPersona.getCmbEtnia().getSelectedIndex() < 1) {
            guardar = false;
            frmPersona.getLblErrorEtnia().setVisible(true);
        } else {
            etnia = frmPersona.getCmbEtnia().getSelectedItem().toString();
            frmPersona.getLblErrorEtnia().setVisible(false);
        }

        if (frmPersona.getCmbTipoSangre().getSelectedIndex() < 1) {
            guardar = false;
            frmPersona.getLblErrorTipoSangre().setVisible(true);
        } else {
            tipoSangre = frmPersona.getCmbTipoSangre().getSelectedItem().toString();
            frmPersona.getLblErrorTipoSangre().setVisible(false);
        }

        discapcidad = frmPersona.getCbxDiscapacidad().isSelected();
        if (discapcidad) {
            carnetConadis = frmPersona.getTxtCarnetConadis().getText();

            if (frmPersona.getCmbTipoDiscapacidad().getSelectedIndex() < 1) {
                frmPersona.getLblErrorTipoDiscapacidad().setVisible(true);
            } else {
                tipoDiscapacidad = frmPersona.getCmbTipoDiscapacidad().getSelectedItem().toString();
                frmPersona.getLblErrorTipoDiscapacidad().setVisible(false);
            }
            porcentajeDiscapacidad = frmPersona.getTxtPorcentaje().getText();
            if (!Validar.esNumeros(porcentajeDiscapacidad)) {
                guardar = false;
                frmPersona.getLblErrorPorcentaje().setVisible(true);
            } else {
                porcentajeDiscapacidad = frmPersona.getTxtPorcentaje().getText();
                frmPersona.getLblErrorPorcentaje().setVisible(false);
            }

        }

        String idioma[];

        if (frmPersona.getCmbIdiomas().getSelectedIndex() < 1) {
            guardar = false;
            frmPersona.getLblErrorIdioma().setVisible(true);
        } else {
            idiomaRaiz = frmPersona.getCmbIdiomas().getSelectedItem().toString();
            idioma = idiomaRaiz.split(" ");
            System.out.println("este solo e sel idioma: " + idioma[0]);
            idiomaRaiz = idioma[0];
            frmPersona.getLblErrorIdioma().setVisible(false);
        }

        telefono = frmPersona.getTxtTelefono().getText();
        if (!Validar.esTelefono(telefono)) {
            guardar = false;
            frmPersona.getLblErrorTelefono().setVisible(true);
        } else {
            frmPersona.getLblErrorTelefono().setVisible(false);
        }

        //para saber como me devuelve el dato
        //Esto deberia ser automatico 
        String fechaReg;
        //Este dato no lo tenemos en base de datos 
        //String codigoPostal = frmPersona.getTxtCodigoPostal().getText();

        callePrin = frmPersona.getTxtCallePrincipal().getText();
        if (!Validar.esLetras(callePrin)) {
            //Mostrar error
            guardar = false;
        } else {
            //Ocultar error
        }

        calleSec = frmPersona.getTxtCalleSecundaria().getText();

        referencia = frmPersona.getTxtReferencia().getText();

        celular = frmPersona.getTxtCelular().getText();
        if (!Validar.esTelefono(celular)) {
            guardar = false;
            frmPersona.getLblErrorCelular().setVisible(true);
        } else {
            frmPersona.getLblErrorCelular().setVisible(false);
        }

        // Lugares en donde reside y vive 
        LugarMD lugarNac = null, lugarRes = null;

        //Esto igual deberiamos hacerlo de otra manera.
        //Aqui preguntamos siempre que sea mayor a la posicion 0 porque 
        //Ahi esta el texto seleccione  
        //Tambien que siempre sea menor iguala al numero de resultados que 
        //tenga porque el ultimo siempre sera otro.
        //Si es otro se guardaria el aterior y no pasara
        int posNac = frmPersona.getCmbNacionalidad().getSelectedIndex();
        if (posNac > 0 && posNac <= paises.size()) {
            frmPersona.getLblErrorNacionalidad().setVisible(false);
            lugarNac = paises.get(posNac - 1);
            int posDis = frmPersona.getCmbProvincia().getSelectedIndex();
            if (posDis > 0 && posDis <= distritos.size()) {
                frmPersona.getLblErrorProvincia().setVisible(false);
                lugarNac = distritos.get(posDis - 1);
                int posCi = frmPersona.getCmbCanton().getSelectedIndex();
                if (posCi > 0 && posCi <= ciudades.size()) {
                    frmPersona.getLblErrorCanton().setVisible(false);
                    lugarNac = ciudades.get(posCi - 1);
                } else {
                    frmPersona.getLblErrorCanton().setVisible(true);
                }
            } else {
                frmPersona.getLblErrorProvincia().setVisible(true);
            }
        } else {
            frmPersona.getLblErrorNacionalidad().setVisible(true);
        }

        int posPro = frmPersona.getCmbProvinciaReside().getSelectedIndex();
        if (posPro > 0 && posPro <= provincias.size()) {
            frmPersona.getLblErrorProvinciaReside().setVisible(false);
            lugarRes = provincias.get(posPro - 1);
            int posCa = frmPersona.getCmbCantonReside().getSelectedIndex();
            if (posCa > 0 && posCa <= cantones.size()) {
                frmPersona.getLblErrorCantonReside().setVisible(false);
                lugarRes = cantones.get(posCa - 1);
                int posPr = frmPersona.getCmbParroquiaReside().getSelectedIndex();
                if (posPr > 0 && posPr <= parroquias.size()) {
                    frmPersona.getLblErrorParroquiaReside().setVisible(false);
                    lugarRes = parroquias.get(posPr - 1);
                } else {
                    frmPersona.getLblErrorParroquiaReside().setVisible(true);
                }
            } else {
                frmPersona.getLblErrorCantonReside().setVisible(true);
            }
        } else {
            frmPersona.getLblErrorProvinciaReside().setVisible(true);
        }
        //Esto creo que deberiamos cambiarlo para hacerlo de otra manera 
        numCasa = frmPersona.getTxtNumeroCasa().getText();
        sector = frmPersona.getTxtSector().getText();
        zonaResidencia = frmPersona.getCmbTipoResidencia().getSelectedItem().toString();
        correo = frmPersona.getTxtCorreo().getText();

        int tipoPer = frmPersona.getCmbTipoPersona().getSelectedIndex();
        if (tipoPer > 0) {
            frmPersona.getLblErrorTipoPersona().setVisible(false);
        } else {
            guardar = false;
            frmPersona.getLblErrorTipoPersona().setVisible(true);
        }

        if (guardar) {
            //Llenar directo por el constructor
            PersonaBD per = new PersonaBD();
            //Pasamos la informacion de la foto 
            per.setFile(fis);
            per.setLogBytes(lonBytes);
            // PersonaBD persona = new PersonaBD(, tipo, lugarNatal, lugarResidencia, foto, identificacion, priApellido, segApellido, priNombre, segNombre, fechaActual, genero, 0, estadoCivil, etnia, idiomaRaiz, tipoSangre, telefono, celular, correo, fechaActual, discapcidad, tipoDiscapacidad, 0, carnetConadis, callePrin, numCasa, calleSec, referencia, sector, idiomaRaiz, zonaResidencia, discapcidad)
            per.setTipo(tiposPer.get(tipoPer - 1));
            per.setIdentificacion(identificacion);
            per.setPrimerNombre(priNombre);
            per.setSegundoNombre(segNombre);
            per.setPrimerApellido(priApellido);
            per.setSegundoApellido(segApellido);
            per.setFechaNacimiento(fechaNacimiento);
            per.setEstadoCivil(estadoCivil);
            per.setCelular(celular);
            per.setTelefono(telefono);
            per.setIdiomaRaiz(idiomaRaiz);
            per.setTipoSangre(tipoSangre);
            per.setGenero(genero);
            per.setSexo(sexo.charAt(0));
            per.setEtnia(etnia);
            per.setCorreo(correo);
            if (discapcidad) {

                per.setDiscapacidad(discapcidad);
                per.setCarnetConadis(carnetConadis);
                per.setTipoDiscapacidad(tipoDiscapacidad);
                per.setPorcentajeDiscapacidad(Integer.parseInt(porcentajeDiscapacidad));

            }
            per.setLugarNatal(lugarNac);
            per.setLugarResidencia(lugarRes);
            //Codigo postal
            per.setTipoResidencia(zonaResidencia);
            per.setCallePrincipal(callePrin);
            per.setCalleSecundaria(calleSec);
            per.setReferencia(referencia);
            per.setSector(sector);
            per.setNumeroCasa(numCasa);
            per.setFechaRegistro(fechaActual);

            if (editar) {
                //Se llama al metodo editar persona de persona BD 
            } else {
                if (fis != null) {
                    per.insertarPersonaConFoto();
                } else {
                    per.insertarPersona();
                }
            }

        } else {
            System.out.println("Existen errores en los formularios");
        }

    }

    public void salirBoton() {
        frmPersona.dispose();
    }

    private void consular() {
        String identificacion = frmPersona.getTxtIdentificacion().getText();
        PersonaMD per = persona.buscarPersona(identificacion);
        if (per != null) {
            editar(per);
        }
    }

    public void editar(PersonaMD per) {
        //Steamos los datos en el formulario  
        editar = true;
        frmPersona.getTxtCallePrincipal().setText(per.getCallePrincipal());
        frmPersona.getTxtCalleSecundaria().setText(per.getCalleSecundaria());
        frmPersona.getTxtCelular().setText(per.getCelular());
        frmPersona.getTxtCorreo().setText(per.getCorreo());
        frmPersona.getTxtNumeroCasa().setText(per.getNumeroCasa());
        frmPersona.getTxtPrimerApellido().setText(per.getPrimerApellido());
        frmPersona.getTxtPrimerNombre().setText(per.getPrimerNombre());
        frmPersona.getTxtReferencia().setText(per.getReferencia());
        frmPersona.getTxtSector().setText(per.getSector());
        frmPersona.getTxtSegundoApellido().setText(per.getSegundoApellido());
        frmPersona.getTxtSegundoNombre().setText(per.getSegundoNombre());
        frmPersona.getTxtTelefono().setText(per.getTelefono());
        
        
        String idioma = per.getIdiomaRaiz();
        System.out.println(idioma); 
        frmPersona.getCmbIdiomas().setSelectedItem(idioma); 
        
        frmPersona.getCmbEstadoCivil().setSelectedItem(per.getEstadoCivil()); 
        //Codigo postal
        /*frmPersona.getTxtCodigoPostal().setText(p);
        
        frmPersona.getTxtCarnetConadis().setText(per.getCarnetConadis());
        frmPersona.getTxtPorcentaje().setText(per.getPorcentajeDiscapacidad());*/
    }

    //Metodo para ocultar errores
    public void ocultarErrores() {
        frmPersona.getLblErrorCallePrin().setVisible(false);
        frmPersona.getLblErrorCalleSec().setVisible(false);
        frmPersona.getLblErrorCanton().setVisible(false);
        frmPersona.getLblErrorCantonReside().setVisible(false);
        frmPersona.getLblErrorCarnetConadis().setVisible(false);
        frmPersona.getLblErrorCelular().setVisible(false);
        frmPersona.getLblErrorCodigoPostal().setVisible(false);
        frmPersona.getLblErrorCorreo().setVisible(false);
        frmPersona.getLblErrorEstadoCivil().setVisible(false);
        frmPersona.getLblErrorEtnia().setVisible(false);
        frmPersona.getLblErrorFecNac().setVisible(false);
        frmPersona.getLblErrorGenero().setVisible(false);
        frmPersona.getLblErrorIdentificacion().setVisible(false);
        frmPersona.getLblErrorIdioma().setVisible(false);
        frmPersona.getLblErrorNacionalidad().setVisible(false);
        frmPersona.getLblErrorNumeroCasa().setVisible(false);
        frmPersona.getLblErrorParroquiaReside().setVisible(false);
        frmPersona.getLblErrorPorcentaje().setVisible(false);
        frmPersona.getLblErrorPriApellido().setVisible(false);
        frmPersona.getLblErrorPriNombre().setVisible(false);
        frmPersona.getLblErrorProvincia().setVisible(false);
        frmPersona.getLblErrorProvinciaReside().setVisible(false);
        frmPersona.getLblErrorReferencia().setVisible(false);
        frmPersona.getLblErrorSector().setVisible(false);
        frmPersona.getLblErrorSegApellido().setVisible(false);
        frmPersona.getLblErrorSegNombre().setVisible(false);
        frmPersona.getLblErrorSexo().setVisible(false);
        frmPersona.getLblErrorTelefono().setVisible(false);
        frmPersona.getLblErrorTipoDiscapacidad().setVisible(false);
        frmPersona.getLblErrorTipoResidencia().setVisible(false);
        frmPersona.getLblErrorTipoSangre().setVisible(false);
        frmPersona.getLblErrorPaisReside().setVisible(false);
    }

    public void cargarTiposPersona() {
        tiposPer = tip.cargarTipoPersona();
        if (tiposPer != null) {
            frmPersona.getCmbTipoPersona().removeAllItems();
            frmPersona.getCmbTipoPersona().addItem("Seleccione");
            tiposPer.forEach((t) -> {
                frmPersona.getCmbTipoPersona().addItem(t.getTipo());
            });
        }
    }

    //Metodos para los combos de residencia y ciudades natales
    private void cargarPaises() {
        paises = lug.buscarPaises();
        paises = ponerPrimeroPais(paises, "ECUADOR");
        frmPersona.getCmbNacionalidad().removeAllItems();
        frmPersona.getCmbNacionalidad().addItem("Seleccione");
        //Cargamos el otro combo de paises 
        frmPersona.getCmbPaisReside().removeAllItems();
        frmPersona.getCmbPaisReside().addItem("Seleccione");
        paises.forEach((l) -> {
            frmPersona.getCmbNacionalidad().addItem(l.getNombre());
            frmPersona.getCmbPaisReside().addItem(l.getNombre());
        });
    }

    //Reordenamos paises para que ecuador este primero  
    private ArrayList<LugarMD> ponerPrimeroPais(ArrayList<LugarMD> lugares, String pais) {
        ArrayList<LugarMD> lugaresOrdenados = new ArrayList();
        lugares.forEach((l) -> {
            if (l.getNombre().equalsIgnoreCase(pais)) {
                lugaresOrdenados.add(l);
            }
        });

        lugares.forEach((l) -> {
            if (!l.getNombre().equalsIgnoreCase(pais)) {
                lugaresOrdenados.add(l);
            }
        });
        return lugaresOrdenados;
    }

    public void cargarDistritosPais() {
        int posNac = frmPersona.getCmbNacionalidad().getSelectedIndex();
        if (posNac > 0) {
            frmPersona.getLblErrorProvincia().setVisible(false);
            distritos = lug.buscarPorReferencia(paises.get(posNac - 1).getId());
            frmPersona.getCmbProvincia().removeAllItems();
            frmPersona.getCmbProvincia().addItem("Seleccione");
            distritos.forEach((l) -> {
                frmPersona.getCmbProvincia().addItem(l.getNombre());
            });
            frmPersona.getCmbProvincia().addItem("OTRO");
        } else {
            frmPersona.getLblErrorProvincia().setVisible(true);
        }
    }

    public void cargarCiudadesDistrito() {
        int posDis = frmPersona.getCmbProvincia().getSelectedIndex();
        if (posDis > 0) {
            frmPersona.getLblErrorCanton().setVisible(false);
            ciudades = lug.buscarPorReferencia(distritos.get(posDis - 1).getId());
            frmPersona.getCmbCanton().removeAllItems();
            frmPersona.getCmbCanton().addItem("Seleccione");
            ciudades.forEach((l) -> {
                frmPersona.getCmbCanton().addItem(l.getNombre());
            });
            frmPersona.getCmbCanton().addItem("OTRO");
        } else {
            frmPersona.getLblErrorCanton().setVisible(true);
        }
    }

    private void cargarProvinciasResidencia() {
        int posPaisRe = frmPersona.getCmbPaisReside().getSelectedIndex();
        if (posPaisRe > 0) {
            frmPersona.getLblErrorPaisReside().setVisible(false);
            provincias = lug.buscarPorReferencia(paises.get(posPaisRe - 1).getId());
            frmPersona.getCmbProvinciaReside().removeAllItems();
            frmPersona.getCmbProvinciaReside().addItem("Seleccione");
            provincias.forEach((l) -> {
                frmPersona.getCmbProvinciaReside().addItem(l.getNombre());
            });
        } else {
            frmPersona.getLblErrorPaisReside().setVisible(true);
        }
    }

    public void cargarCantonesProvincia() {
        int posPr = frmPersona.getCmbProvinciaReside().getSelectedIndex();
        if (posPr > 0) {
            frmPersona.getLblErrorCantonReside().setVisible(false);
            cantones = lug.buscarPorReferencia(provincias.get(posPr - 1).getId());
            frmPersona.getCmbCantonReside().removeAllItems();
            frmPersona.getCmbCantonReside().addItem("Seleccione");
            cantones.forEach((l) -> {
                frmPersona.getCmbCantonReside().addItem(l.getNombre());
            });
            frmPersona.getCmbCantonReside().addItem("OTRO");
        } else {
            frmPersona.getLblErrorCantonReside().setVisible(true);
        }
    }

    public void cargarParroquiaCanton() {
        int posCt = frmPersona.getCmbCantonReside().getSelectedIndex();
        if (posCt > 0) {
            frmPersona.getLblErrorParroquiaReside().setVisible(false);
            parroquias = lug.buscarPorReferencia(cantones.get(posCt - 1).getId());
            frmPersona.getCmbParroquiaReside().removeAllItems();
            frmPersona.getCmbParroquiaReside().addItem("Seleccione");
            parroquias.forEach((l) -> {
                frmPersona.getCmbParroquiaReside().addItem(l.getNombre());
            });
            frmPersona.getCmbParroquiaReside().addItem("OTRO");
        } else {
            frmPersona.getLblErrorParroquiaReside().setVisible(true);
        }
    }

    public void cargarCodigoPostal() {
        int posPa = frmPersona.getCmbParroquiaReside().getSelectedIndex();
        if (posPa > 0 && posPa < parroquias.size()) {
            frmPersona.getTxtCodigoPostal().setText(parroquias.get(posPa - 1).getCodigo());
        } else {
            frmPersona.getTxtCodigoPostal().setText("");
        }
    }
}
