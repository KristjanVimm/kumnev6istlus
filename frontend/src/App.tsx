import './App.css'
import NavigationBar from './components/NavigationBar';
import { Route, Routes } from 'react-router-dom';
import HomePage from './pages/HomePage';
import NotFound from './pages/NotFound';
import AddAthlete from './pages/AddAthlete';
import AddOutcome from './pages/AddOutcome';

function App() {

  return (
    <>
        <NavigationBar />

        <Routes>
          <Route path='/' element={<HomePage />}/>
          <Route path='/add-athlete' element={<AddAthlete />}/>
          <Route path='/add-outcome' element={<AddOutcome />}/>
          <Route path='*' element={<NotFound />}/>
        </Routes>
    </>
  )
}

export default App
