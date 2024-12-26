import {BrowserRouter, Route, Routes} from 'react-router-dom';

import Header from './components/header/Header.jsx';
import Footer from './components/footer/Footer.jsx';
import AddPatient from './components/add-patient/AddPatient.jsx';
import ListPatients from './components/list-patients/ListPatients.jsx';
import ViewPatient from './components/patient-details/ViewPatient.jsx';
import UpdatePatient from './components/update-patient/UpdatePatient.jsx';

function App() {

  return (
    <BrowserRouter basename="/crud/">
    <Header/>
    <Routes>
    <Route path="/" element={<ListPatients/>}/>
    <Route path="add-patient" element={<AddPatient/>}/>
    <Route path="list-patients" element={<ListPatients/>}/>
    <Route path="patient-details" element={ <ViewPatient/> }/>
    <Route path="update-patient/:patientId" element={ <UpdatePatient/>}/>
    </Routes>
    <Footer/>
    </BrowserRouter>
  )
}

export default App
