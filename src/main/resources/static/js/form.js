const btnNew = document.querySelector('.form-input .btn-new');
if (btnNew) {
	btnNew.addEventListener('click', () => {
		const inPutFade = document.querySelector('.input');
		const inPut = document.querySelector('.new');
		if (btnNew.innerText === 'New') {
			inPutFade.classList.remove('JS-fade');
			inPut.classList.add('JS-fade');
			btnNew.innerText = 'Cancel';
		} else {
			inPut.value = '';
			inPutFade.classList.add('JS-fade');
			inPut.classList.remove('JS-fade');
			btnNew.innerText = 'New';
		}
	})
}
