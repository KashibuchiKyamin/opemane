/**
 * プロジェクト一覧用js
 */

/**
 * のちのち共通化予定
 * @param url - リクエスト先url文字列
 * @param destFunction - レスポンスボディの連想配列を引数で受け取り処理をする関数
 */
function requestSubjectData(url, destFunction) {

	fetch(url)
		.then((response) => response.json())
		.then((data) => {
			console.log(data);
			destFunction(data);
		});
}

/**
 * 連想配列を元にテーブルを作成し、表示する
 * @param subjectHashes 案件情報の連想配列
 */
const createTable = function createTable(subjectHashes) {
	const subjects = subjectHashes.subjects;
	let rowCount = 1;
	console.log(subjectHashes);

	const tableObject = document.getElementById('subject-table');

	Object.keys(subjects).forEach(function(key) {
		const row = tableObject.insertRow(-1);
		const noCell = row.insertCell(0); // 0: No.列
		noCell.appendChild(document.createTextNode(rowCount++))
		const subjectCell = row.insertCell(1); // 1: プロジェクト名列
		subjectCell.appendChild(document.createTextNode(subjects[key].name))
		const codeCell = row.insertCell(2); // 2: コード列
		codeCell.appendChild(document.createTextNode(subjects[key].code))
	});

	const mainContents = document.getElementById('main-contents');
	mainContents.classList.remove('show-progress');
	mainContents.classList.add('show-contents');
}